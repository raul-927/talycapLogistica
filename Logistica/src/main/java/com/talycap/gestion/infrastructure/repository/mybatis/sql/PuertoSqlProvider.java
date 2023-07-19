package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.PuertoEntity;

public class PuertoSqlProvider {
	
	public String insert(PuertoEntity puerto) {
		String query = new SQL() {{
			INSERT_INTO("puerto");
			if(puerto.getDescripcion()!=null && !puerto.getDescripcion().isEmpty()) {
				VALUES("descripcion", "'".concat(puerto.getDescripcion()).concat("'"));
			}
			if(puerto.getUbicacion()!=null) {
				VALUES("ubicacion", "'".concat(puerto.getUbicacion().name()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(PuertoEntity puerto) {
		return new SQL() {{
			UPDATE("puerto");
			if(puerto.getDescripcion()!=null && !puerto.getDescripcion().isEmpty()) {
				SET("descripcion = "+ "'".concat(puerto.getDescripcion()).concat("'"));
			}
			if(puerto.getUbicacion()!=null) {
				SET("ubicacion = "+ "'".concat(puerto.getUbicacion().name()).concat("'"));
			}
			WHERE("puerto_id = " + String.valueOf(puerto.getPuertoId()));
		}}.toString();
	}
	
	public String delete(PuertoEntity puerto) {
		return new SQL() {{
			if(puerto !=null) {
				DELETE_FROM("puerto");
				WHERE("puerto_id = " + String.valueOf(puerto.getPuertoId()));
			}
		}}.toString();
	}
	
	public String select(PuertoEntity puerto) {
		SQL sql = new SQL() {{
			SELECT("p.puerto_id, p.descripcion, p.ubicacion");
			FROM("puerto p");
			if(puerto != null) {
				if(puerto.getPuertoId()!=0 && puerto.getPuertoId() > 0) {
					WHERE("p.puerto_id = " + String.valueOf(puerto.getPuertoId()));
				}
				else {
					if(puerto.getDescripcion()!=null && !puerto.getDescripcion().isEmpty()) {
						WHERE("p.descripcion LIKE " +"'%".concat(puerto.getDescripcion()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}