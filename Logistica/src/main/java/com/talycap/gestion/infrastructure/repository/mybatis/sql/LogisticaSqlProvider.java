package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import java.math.BigDecimal;

import org.apache.ibatis.jdbc.SQL;

import com.talycap.gestion.domain.enumerador.TipoLogisticaEnum;
import com.talycap.gestion.infrastructure.entitys.LogisticaEntity;

public class LogisticaSqlProvider {
	
	public String insert(LogisticaEntity logistica) {
		String query = new SQL() {{
			INSERT_INTO("logistica");
			if(logistica.getCliente()!=null) {
				VALUES("cliente_id", "'".concat(String.valueOf(logistica.getCliente().getClienteId())).concat("'"));
			}
			if(logistica.getLogisticaTerrestre()!=null) {
				VALUES("logistica_terrestre_id", "'".concat(String.valueOf(logistica.getLogisticaTerrestre().getLogisticaTerrestreId())).concat("'"));
			}
			if(logistica.getLogisticaMaritima()!=null) {
				VALUES("logistica_maritima_id", "'".concat(String.valueOf(logistica.getLogisticaMaritima().getLogisticaMaritimaId())).concat("'"));
			}
			if(logistica.getTipoProducto()!=null) {
				VALUES("tipo_producto_id","'".concat(String.valueOf(logistica.getTipoProducto().getTipoProductoId())).concat("'"));
			}
			if(logistica.getFechaEntrega()!=null) {
				VALUES("fecha_entrega", "'".concat(logistica.getFechaEntrega().toString()).concat("'"));
			}
			if(logistica.getFechaRegistro()!=null) {
				VALUES("fecha_registro", "'".concat(logistica.getFechaRegistro().toString()).concat("'"));
			}
			if(logistica.getTipoLogistica()!=null) {
				VALUES("tipo_logistica","'".concat(logistica.getTipoLogistica().name()).concat("'"));
			}
			VALUES("precio_envio", "'".concat(String.valueOf(logistica.getPrecioEnvio())).concat("'"));
			VALUES("cantidad_producto","'".concat(String.valueOf(logistica.getCantidadProducto())).concat("'"));
			VALUES("sub_total","'".concat(String.valueOf(logistica.getSubTotal())).concat("'"));
			VALUES("porcentaje_descuento","'".concat(String.valueOf(logistica.getPorcentajeDescuento())).concat("'"));
			VALUES("total", "'".concat(String.valueOf(logistica.getTotal())).concat("'"));
			
			
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(LogisticaEntity logistica) {
		return new SQL() {{
			UPDATE("logistica");
			
			if(logistica.getCliente()!=null) {
				SET("cliente_id = "+ "'".concat(String.valueOf(logistica.getCliente().getClienteId())).concat("'"));
			}
			if(logistica.getLogisticaTerrestre()!=null) {
				SET("logistica_terrestre_id = "+ "'".concat(String.valueOf(logistica.getLogisticaTerrestre().getLogisticaTerrestreId())).concat("'"));
			}
			if(logistica.getLogisticaMaritima()!=null) {
				SET("logistica_maritima_id = "+ "'".concat(String.valueOf(logistica.getLogisticaMaritima().getLogisticaMaritimaId())).concat("'"));
			}
			if(logistica.getTipoProducto()!=null) {
				SET("tipo_producto_id = "+"'".concat(String.valueOf(logistica.getTipoProducto().getTipoProductoId())).concat("'"));
			}
			
			if(logistica.getPrecioEnvio().compareTo(new BigDecimal(0))> 0) {
				SET("precio_envio = "+ "'".concat(String.valueOf(logistica.getPrecioEnvio())).concat("'"));
			}
			
			if(logistica.getCantidadProducto() > 0) {
				SET("cantidad_producto = "+"'".concat(String.valueOf(logistica.getCantidadProducto())).concat("'"));
			}
			
			if(logistica.getSubTotal().compareTo(new BigDecimal(0)) > 0) {
				SET("sub_total = "+"'".concat(String.valueOf(logistica.getSubTotal())).concat("'"));
			}
			
			SET("porcentaje_descuento = "+"'".concat(String.valueOf(logistica.getPorcentajeDescuento())).concat("'"));
			SET("total = "+ "'".concat(String.valueOf(logistica.getTotal())).concat("'"));
			SET("fecha_registro = "+ "'".concat(logistica.getFechaRegistro().toString()).concat("'"));
			SET("fecha_entrega = "+ "'".concat(logistica.getFechaEntrega().toString()).concat("'"));
			
			WHERE("logistica_id = " + String.valueOf(logistica.getLogisticaId()));
		}}.toString();
	}
	
	public String delete(LogisticaEntity logistica) {
		return new SQL() {{
			if(logistica !=null) {
				DELETE_FROM("logistica");
				WHERE("logistica_id = " + String.valueOf(logistica.getLogisticaId()));
			}
		}}.toString();
	}
	
	public String select(LogisticaEntity logistica) {
		SQL sql = new SQL() {{
			SELECT("l.logistica_id, l.precio_envio, l.cantidad_producto, l.sub_total, l.porcentaje_descuento, l.total, l.fecha_registro, l.fecha_entrega, l.tipo_logistica");
			SELECT("t.tipo_producto_id, t.nombre_tipo_producto");
			SELECT("cli.cliente_id, cli.nombre, cli.apellido, cli.documento");
			if(logistica.getTipoLogistica()!= null && logistica.getTipoLogistica() == TipoLogisticaEnum.MARITIMA) {
				SELECT("lm.logistica_maritima_id, lm.barco_id, lm.puerto_id");
				SELECT("b.barco_id, b.nro_flota, b.nombre_barco");
				SELECT("p.puerto_id, p.descripcion, p.ubicacion");
				FROM("logistica_maritima lm");
				FROM("barco b");
				FROM("puerto p");
				WHERE("lm.barco_id = b.barco_id");
				WHERE("lm.puerto_id = p.puerto_id");
			}else
				if(logistica.getTipoLogistica()!= null && logistica.getTipoLogistica() == TipoLogisticaEnum.TERRESTRE) {
				SELECT("lt.logistica_terrestre_id");
				SELECT("c.camion_id, c.placa, c.marca, c.modelo");
				SELECT("b.bodega_id, b.nombre_bodega");
				FROM("logistica_terrestre lt");
				FROM("camion c");
				FROM("bodega b");
				WHERE("lt.camion_id = c.camion_id");
				WHERE("lt.bodega_id = b.bodega_id");
			}
			FROM("logistica l");
			FROM("tipo_producto t");
			FROM("cliente cli");
			
			
			if(logistica!=null && logistica.getLogisticaMaritima()!=null && logistica.getLogisticaMaritima().getLogisticaMaritimaId() > 0) {
				
				WHERE("lm.logistica_maritima_id = l.logistica_maritima_id");
			}
			if(logistica!=null && logistica.getLogisticaTerrestre()!=null && logistica.getLogisticaTerrestre().getLogisticaTerrestreId() > 0) {
				
				WHERE("lt.logistica_terrestre_id = l.logistica_terrestre_id");
			}
			
			WHERE("l.tipo_producto_id = t.tipo_producto_id");
			WHERE("l.cliente_id = cli.cliente_id");
			
			if(logistica != null) {
				if(logistica.getLogisticaId()!=0 && logistica.getLogisticaId() > 0) {
					WHERE("l.logistica_id = " + String.valueOf(logistica.getLogisticaId()));
				}
				else {
					if(logistica.getFechaEntrega()!=null) {
						WHERE("l.fecha_entrega LIKE " +"'%".concat(logistica.getFechaEntrega().toString()).concat("%'"));
					}
					if(logistica.getFechaRegistro()!=null) {
						WHERE("l.fecha_registro LIKE " + "'%".concat(logistica.getFechaRegistro().toString()).concat("%'"));
					}
					if(logistica.getTipoLogistica()!= null) {
						WHERE("tipo_logistica = "+"'".concat(logistica.getTipoLogistica().name()).concat("'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}