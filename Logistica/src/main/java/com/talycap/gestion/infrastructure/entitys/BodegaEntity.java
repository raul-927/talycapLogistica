package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;

public class BodegaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int bodegaId;
	private String nombreBodega;
	public int getBodegaId() {
		return bodegaId;
	}
	public void setBodegaId(int bodegaId) {
		this.bodegaId = bodegaId;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	

}
