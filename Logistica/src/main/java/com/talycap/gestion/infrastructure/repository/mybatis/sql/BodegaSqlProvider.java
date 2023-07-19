package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.BodegaEntity;

public class BodegaSqlProvider {
	
	public String insert(BodegaEntity bodega) {
		String query = new SQL() {{
			INSERT_INTO("bodega");
			if(bodega.getNombreBodega()!=null && !bodega.getNombreBodega().isEmpty()) {
				VALUES("nombre_bodega", "'".concat(bodega.getNombreBodega()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(BodegaEntity bodega) {
		return new SQL() {{
			UPDATE("bodega");
			if(bodega.getNombreBodega()!=null && !bodega.getNombreBodega().isEmpty()) {
				SET("nombre_bodega = "+ "'".concat(bodega.getNombreBodega()).concat("'"));
			}
			WHERE("bodega_id = " + String.valueOf(bodega.getBodegaId()));
		}}.toString();
	}
	
	public String delete(BodegaEntity bodega) {
		return new SQL() {{
			if(bodega !=null) {
				DELETE_FROM("bodega");
				WHERE("bodega_id = " + String.valueOf(bodega.getBodegaId()));
			}
		}}.toString();
	}
	
	public String select(BodegaEntity bodega) {
		SQL sql = new SQL() {{
			SELECT("b.bodega_id, b.nombre_bodega");
			FROM("bodega b");
			if(bodega != null) {
				if(bodega.getBodegaId()!=0 && bodega.getBodegaId() > 0) {
					WHERE("b.bodega_id = " + String.valueOf(bodega.getBodegaId()));
				}
				else {
					if(bodega.getNombreBodega()!=null && !bodega.getNombreBodega().isEmpty()) {
						WHERE("b.nombre_bodega LIKE " +"'%".concat(bodega.getNombreBodega()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}