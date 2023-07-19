package com.talycap.gestion.domain.models;

import com.talycap.gestion.domain.enumerador.UbicacionEnum;

public class Puerto {
	
	private int puertoId;
	private String descripcion;
	private UbicacionEnum ubicacion;
	
	public int getPuertoId() {
		return puertoId;
	}
	public void setPuertoId(int puertoId) {
		this.puertoId = puertoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UbicacionEnum getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionEnum ubicacion) {
		this.ubicacion = ubicacion;
	}

}
