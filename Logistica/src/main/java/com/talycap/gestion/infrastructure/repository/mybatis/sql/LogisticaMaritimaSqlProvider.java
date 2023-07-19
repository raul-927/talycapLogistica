package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.LogisticaMaritimaEntity;

public class LogisticaMaritimaSqlProvider {
	
	public String insert(LogisticaMaritimaEntity logisticaMaritima) {
		String query = new SQL() {{
			INSERT_INTO("logistica_maritima");
			if(logisticaMaritima.getBarco()!=null) {
				VALUES("barco_id", "'".concat(String.valueOf(logisticaMaritima.getBarco().getBarcoId())).concat("'"));
			}
			if(logisticaMaritima.getPuerto()!=null) {
				VALUES("puerto_id", "'".concat(String.valueOf(logisticaMaritima.getPuerto().getPuertoId())).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(LogisticaMaritimaEntity logisticaMaritima) {
		return new SQL() {{
			UPDATE("logistica_maritima");
			
			if(logisticaMaritima.getBarco()!=null) {
				SET("barco_id = "+ "'".concat(String.valueOf(logisticaMaritima.getBarco().getBarcoId())).concat("'"));
			}
			if(logisticaMaritima.getPuerto()!=null) {
				SET("puerto_id = "+ "'".concat(String.valueOf(logisticaMaritima.getPuerto().getPuertoId())).concat("'"));
			}
			
			WHERE("logistica_maritima_id = " + String.valueOf(logisticaMaritima.getLogisticaMaritimaId()));
		}}.toString();
	}
	
	public String delete(LogisticaMaritimaEntity logisticaMaritima) {
		return new SQL() {{
			if(logisticaMaritima !=null) {
				DELETE_FROM("logistica_maritima");
				WHERE("logistica_maritima_id = " + String.valueOf(logisticaMaritima.getLogisticaMaritimaId()));
			}
		}}.toString();
	}
	
	public String select(LogisticaMaritimaEntity logisticaMaritima) {
		SQL sql = new SQL() {{
			SELECT("lm.logistica_maritima_id");
			SELECT("b.barco_id, b.nro_flota, b.nombre_barco");
			SELECT("p.puerto_id, p.descripcion, p.ubicacion");
			FROM("logistica_maritima lm");
			FROM("barco b");
			FROM("puerto p");
			WHERE("lm.barco_id = b.barco_id");
			WHERE("lm.puerto_id = p.puerto_id");
			if(logisticaMaritima!=null) {
				WHERE("lm.logistica_maritima_id = "+"'".concat(String.valueOf(logisticaMaritima.getLogisticaMaritimaId())).concat("'"));
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}