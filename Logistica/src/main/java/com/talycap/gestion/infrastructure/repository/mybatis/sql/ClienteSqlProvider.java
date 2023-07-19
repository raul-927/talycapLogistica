package com.talycap.gestion.infrastructure.repository.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import com.talycap.gestion.infrastructure.entitys.ClienteEntity;

public class ClienteSqlProvider {
	
	public String insert(ClienteEntity cliente) {
		String query = new SQL() {{
			INSERT_INTO("cliente");
			if(cliente.getNombre()!=null && !cliente.getNombre().isEmpty()) {
				VALUES("nombre", "'".concat(cliente.getNombre()).concat("'"));
			}
			if(cliente.getApellido()!=null && !cliente.getApellido().isEmpty()) {
				VALUES("apellido", "'".concat(cliente.getApellido()).concat("'"));
			}
			if(cliente.getDocumento()!=null && !cliente.getDocumento().isEmpty()) {
				VALUES("documento", "'".concat(cliente.getDocumento()).concat("'"));
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(ClienteEntity cliente) {
		return new SQL() {{
			UPDATE("cliente");
			if(cliente.getNombre()!=null && !cliente.getNombre().isEmpty()) {
				SET("nombre = "+ "'".concat(cliente.getNombre()).concat("'"));
			}
			if(cliente.getApellido()!=null && !cliente.getApellido().isEmpty()) {
				SET("apellido = "+ "'".concat(cliente.getApellido()).concat("'"));
			}
			if(cliente.getDocumento()!=null && !cliente.getDocumento().isEmpty()) {
				SET("documento = "+ "'".concat(cliente.getDocumento()).concat("'"));
			}
			WHERE("cliente_id = " + String.valueOf(cliente.getClienteId()));
		}}.toString();
	}
	
	public String delete(ClienteEntity cliente) {
		return new SQL() {{
			if(cliente !=null) {
				DELETE_FROM("cliente");
				WHERE("cliente_id = " + String.valueOf(cliente.getClienteId()));
			}
		}}.toString();
	}
	
	public String select(ClienteEntity cliente) {
		SQL sql = new SQL() {{
			SELECT("c.cliente_id, c.nombre, c.apellido, c.documento");
			FROM("cliente c");
			if(cliente != null) {
				if(cliente.getClienteId()!=0 && cliente.getClienteId() > 0) {
					WHERE("c.cliente_id = " + String.valueOf(cliente.getClienteId()));
				}
				else {
					if(cliente.getNombre()!=null && !cliente.getNombre().isEmpty()) {
						WHERE("c.nombre LIKE " +"'%".concat(cliente.getNombre()).concat("%'"));
					}
					if(cliente.getApellido()!=null && !cliente.getApellido().isEmpty()) {
						WHERE("c.apellido LIKE " + "'%".concat(cliente.getApellido()).concat("%'"));
					}
					if(cliente.getDocumento()!=null && !cliente.getDocumento().isEmpty()) {
						WHERE("c.documento LIKE " + "'%".concat(cliente.getDocumento()).concat("%'"));
					}
				}
			}
		}};
		System.out.print("SQL: "+sql.toString());
		return sql.toString();
	}
}