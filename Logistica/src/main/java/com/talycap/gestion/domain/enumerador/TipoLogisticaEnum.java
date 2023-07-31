package com.talycap.gestion.domain.enumerador;

public enum TipoLogisticaEnum {
	MARITIMA(1,"MARITIMA"),
	TERRESTRE(2, "TERRESTRE");
	
	
	private int id;
	private String descripcion;
	
	private TipoLogisticaEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

}
