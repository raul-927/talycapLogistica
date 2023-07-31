package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.LogisticaTerrestreEntity;

public class LogisticaTerrestreSqlProvider {
	
	public String insert(LogisticaTerrestreEntity logisticaTerrestre) {
		String query = new SQL() {{
			if(logisticaTerrestre != null) {
				INSERT_INTO("logistica_terrestre");
				if(logisticaTerrestre.getBodega()!=null) {
					VALUES("bodega_id", "'".concat(String.valueOf(logisticaTerrestre.getBodega().getBodegaId())).concat("'"));
				}
				if(logisticaTerrestre.getCamion()!=null) {
					VALUES("camion_id", "'".concat(String.valueOf(logisticaTerrestre.getCamion().getCamionId())).concat("'"));
				}
			}
			
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(LogisticaTerrestreEntity logisticaTerrestre) {
		return new SQL() {{
			UPDATE("logistica_terrestre");
			
			if(logisticaTerrestre.getCamion()!=null) {
				SET("camion_id = "+ "'".concat(String.valueOf(logisticaTerrestre.getCamion().getCamionId())).concat("'"));
			}
			if(logisticaTerrestre.getBodega()!=null) {
				SET("bodega_id = "+ "'".concat(String.valueOf(logisticaTerrestre.getBodega().getBodegaId())).concat("'"));
			}
			
			WHERE("logistica_terrestre_id = " + String.valueOf(logisticaTerrestre.getLogisticaTerrestreId()));
		}}.toString();
	}
	
	public String delete(LogisticaTerrestreEntity logisticaTerrestre) {
		return new SQL() {{
			if(logisticaTerrestre !=null) {
				DELETE_FROM("logistica_terrestre");
				WHERE("logistica_terrestre_id = " + String.valueOf(logisticaTerrestre.getLogisticaTerrestreId()));
			}
		}}.toString();
	}
	
	public String select(LogisticaTerrestreEntity logisticaTerrestre) {
		SQL sql = new SQL() {{
			SELECT("lt.logistica_terrestre_id");
			SELECT("c.camion_id, c.placa, c.marca, c.modelo");
			SELECT("b.bodega_id, b.nombre_bodega");
			FROM("logistica_terrestre lt");
			FROM("camion c");
			FROM("bodega b");
			WHERE("lt.camion_id = c.camion_id");
			WHERE("lt.bodega_id = b.bodega_id");
			if(logisticaTerrestre!=null) {
				WHERE("lt.logistica_terrestre_id = "+"'".concat(String.valueOf(logisticaTerrestre.getLogisticaTerrestreId())).concat("'"));
			}
		}};
		System.out.print("SQL2: "+sql.toString());
		return sql.toString();
	}
}