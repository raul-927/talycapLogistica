package com.talycap.gestion.domain.models;

public class LogisticaMaritima{
	private int logisticaMaritimaId;
	private Barco barco;
	private Puerto puerto;
	
	
	public int getLogisticaMaritimaId() {
		return logisticaMaritimaId;
	}
	public void setLogisticaMaritimaId(int logisticaMaritimaId) {
		this.logisticaMaritimaId = logisticaMaritimaId;
	}
	public Barco getBarco() {
		return barco;
	}
	public void setBarco(Barco barco) {
		this.barco = barco;
	}
	public Puerto getPuerto() {
		return puerto;
	}
	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}

}
