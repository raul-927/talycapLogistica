package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;

public class LogisticaTerrestreEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int logisticaTerrestreId;
	private CamionEntity camion;
	private BodegaEntity bodega;
	
	
	public int getLogisticaTerrestreId() {
		return logisticaTerrestreId;
	}
	public void setLogisticaTerrestreId(int logisticaTerrestreId) {
		this.logisticaTerrestreId = logisticaTerrestreId;
	}
	public CamionEntity getCamion() {
		return camion;
	}
	public void setCamion(CamionEntity camion) {
		this.camion = camion;
	}
	public BodegaEntity getBodega() {
		return bodega;
	}
	public void setBodega(BodegaEntity bodega) {
		this.bodega = bodega;
	}

}
