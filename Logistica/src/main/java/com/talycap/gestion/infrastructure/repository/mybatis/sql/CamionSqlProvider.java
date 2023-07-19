package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.CamionEntity;

public class CamionSqlProvider {
	
	public String insert(CamionEntity camion) {
		String query = new SQL() {{
			INSERT_INTO("camion");
			if(camion.getMarca()!=null && !camion.getMarca().isEmpty()) {
				VALUES("marca", "'".concat(camion.getMarca()).concat("'"));
			}
			if(camion.getModelo()!=null && !camion.getModelo().isEmpty()) {
				VALUES("modelo", "'".concat(camion.getModelo()).concat("'"));
			}
			if(camion.getPlaca()!=null && !camion.getPlaca().isEmpty()) {
				VALUES("placa", "'".concat(camion.getPlaca()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(CamionEntity camion) {
		return new SQL() {{
			UPDATE("camion");
			if(camion.getMarca()!=null && !camion.getMarca().isEmpty()) {
				SET("marca = "+ "'".concat(camion.getMarca()).concat("'"));
			}
			if(camion.getModelo()!=null && !camion.getModelo().isEmpty()) {
				SET("modelo = "+ "'".concat(camion.getModelo()).concat("'"));
			}
			if(camion.getPlaca()!=null && !camion.getPlaca().isEmpty()) {
				SET("placa = "+ "'".concat(camion.getPlaca()).concat("'"));
			}
			WHERE("camion_id = " + String.valueOf(camion.getCamionId()));
		}}.toString();
	}
	
	public String delete(CamionEntity camion) {
		return new SQL() {{
			if(camion !=null) {
				DELETE_FROM("camion");
				WHERE("camion_id = " + String.valueOf(camion.getCamionId()));
			}
		}}.toString();
	}
	
	public String select(CamionEntity camion) {
		SQL sql = new SQL() {{
			SELECT("c.camion_id, c.marca, c.modelo, c.placa");
			FROM("camion c");
			if(camion != null) {
				if(camion.getCamionId()!=0 && camion.getCamionId() > 0) {
					WHERE("c.camion_id = " + String.valueOf(camion.getCamionId()));
				}
				else {
					if(camion.getMarca()!=null && !camion.getMarca().isEmpty()) {
						WHERE("c.marca LIKE " +"'%".concat(camion.getMarca()).concat("%'"));
					}
					if(camion.getModelo()!=null && !camion.getModelo().isEmpty()) {
						WHERE("c.modelo LIKE " + "'%".concat(camion.getModelo()).concat("%'"));
					}
					if(camion.getPlaca()!=null && !camion.getPlaca().isEmpty()) {
						WHERE("c.placa LIKE " + "'%".concat(camion.getPlaca()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}