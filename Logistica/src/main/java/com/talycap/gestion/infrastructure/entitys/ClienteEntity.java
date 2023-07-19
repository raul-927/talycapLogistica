package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;

public class ClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int clienteId;
	private String nombre;
	private String apellido;
	private String documento;
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
