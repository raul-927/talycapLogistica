package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;

public class TipoProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private  int tipoProductoId;
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
