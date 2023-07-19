package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.BarcoEntity;

public class BarcoSqlProvider {
	
	public String insert(@Param("barco") BarcoEntity barco) {
		String query = new SQL() {{
			INSERT_INTO("barco");
			if(barco.getNombreBarco()!=null && !barco.getNombreBarco().isEmpty()) {
				VALUES("nombre_barco", "'".concat(barco.getNombreBarco()).concat("'"));
			}
			if(barco.getNroFlota()!=null && !barco.getNroFlota().isEmpty()) {
				VALUES("nro_flota", "'".concat(barco.getNroFlota()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(@Param("barco") BarcoEntity barco) {
		return new SQL() {{
			UPDATE("barco");
			if(barco.getNombreBarco()!=null && !barco.getNombreBarco().isEmpty()) {
				SET("nombre_barco = "+ "'".concat(barco.getNombreBarco()).concat("'"));
			}
			if(barco.getNroFlota()!=null && !barco.getNroFlota().isEmpty()) {
				SET("nro_flota = "+ "'".concat(barco.getNroFlota()).concat("'"));
			}
			WHERE("barco_id = " + String.valueOf(barco.getBarcoId()));
		}}.toString();
	}
	
	public String delete(@Param("barco") BarcoEntity barco) {
		return new SQL() {{
			if(barco !=null) {
				DELETE_FROM("barco");
				WHERE("barco_id = " + String.valueOf(barco.getBarcoId()));
			}
		}}.toString();
	}
	
	public String select(@Param("barco") BarcoEntity barco) {
		SQL sql = new SQL() {{
			SELECT("b.barco_id, b.nombre_barco, b.nro_flota");
			FROM("barco b");
			if(barco != null) {
				if(barco.getBarcoId()!=0 && barco.getBarcoId() > 0) {
					WHERE("b.barco_id = " + String.valueOf(barco.getBarcoId()));
				}
				else {
					if(barco.getNombreBarco()!=null && !barco.getNombreBarco().isEmpty()) {
						WHERE("b.nombre_barco LIKE " +"'%".concat(barco.getNombreBarco()).concat("%'"));
					}
					if(barco.getNroFlota()!=null && !barco.getNroFlota().isEmpty()) {
						WHERE("b.nro_flota LIKE " + "'%".concat(barco.getNroFlota()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}