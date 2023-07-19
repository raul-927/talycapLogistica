package com.talycap.gestion.infrastructure.entitys;

import java.io.Serializable;

public class LogisticaMaritimaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int logisticaMaritimaId;
	private BarcoEntity barco;
	private PuertoEntity puerto;
	
	
	public int getLogisticaMaritimaId() {
		return logisticaMaritimaId;
	}
	public void setLogisticaMaritimaId(int logisticaMaritimaId) {
		this.logisticaMaritimaId = logisticaMaritimaId;
	}
	public BarcoEntity getBarco() {
		return barco;
	}
	public void setBarco(BarcoEntity barco) {
		this.barco = barco;
	}
	public PuertoEntity getPuerto() {
		return puerto;
	}
	public void setPuerto(PuertoEntity puerto) {
		this.puerto = puerto;
	}

}
