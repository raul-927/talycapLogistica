package com.talycap.gestion.domain.models;

public final class TipoProducto {
	
	private int tipoProductoId;
	private  String nombreTipoProducto;
	public int getTipoProductoId() {
		return tipoProductoId;
	}
	public void setTipoProductoId(int tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}
}
