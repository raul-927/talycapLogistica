package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.TipoProductoEntity;

public class TipoProductoSqlProvider {
	
	public String insert(TipoProductoEntity tipoProducto) {
		String query = new SQL() {{
			INSERT_INTO("tipo_producto");
			if(tipoProducto.getNombreTipoProducto()!=null && !tipoProducto.getNombreTipoProducto().isEmpty()) {
				VALUES("nombre_tipo_producto", "'".concat(tipoProducto.getNombreTipoProducto()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(TipoProductoEntity tipoProducto) {
		return new SQL() {{
			UPDATE("tipo_producto");
			if(tipoProducto.getNombreTipoProducto()!=null && !tipoProducto.getNombreTipoProducto().isEmpty()) {
				SET("nombre_tipo_producto = "+ "'".concat(tipoProducto.getNombreTipoProducto()).concat("'"));
			}
			
			WHERE("tipo_producto_id = " + String.valueOf(tipoProducto.getTipoProductoId()));
		}}.toString();
	}
	
	public String delete(TipoProductoEntity tipoProducto) {
		return new SQL() {{
			if(tipoProducto !=null) {
				DELETE_FROM("tipo_producto");
				WHERE("tipo_producto_id = " + String.valueOf(tipoProducto.getTipoProductoId()));
			}
		}}.toString();
	}
	
	public String select(TipoProductoEntity tipoProducto) {
		SQL sql = new SQL() {{
			SELECT("t.tipo_producto_id, t.nombre_tipo_producto");
			FROM("tipo_producto t");
			if(tipoProducto != null) {
				if(tipoProducto.getTipoProductoId()!=0 && tipoProducto.getTipoProductoId() > 0) {
					WHERE("t.tipo_producto_id = " + String.valueOf(tipoProducto.getTipoProductoId()));
				}
				else {
					if(tipoProducto.getNombreTipoProducto()!=null && !tipoProducto.getNombreTipoProducto().isEmpty()) {
						WHERE("p.nombre_tipo_producto LIKE " +"'%".concat(tipoProducto.getNombreTipoProducto()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}