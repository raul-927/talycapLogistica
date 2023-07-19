package com.talycap.gestion.domain.models;

public class LogisticaTerrestre{
	private int logisticaTerrestreId;
	private Camion camion;
	private Bodega bodega;
	
	
	public int getLogisticaTerrestreId() {
		return logisticaTerrestreId;
	}
	public void setLogisticaTerrestreId(int logisticaTerrestreId) {
		this.logisticaTerrestreId = logisticaTerrestreId;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public Bodega getBodega() {
		return bodega;
	}
	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

}
