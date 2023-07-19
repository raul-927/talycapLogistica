package com.talycap.gestion.domain.models;

import javax.validation.constraints.Pattern;

public class Barco {
	
	private int barcoId;
	@Pattern(regexp = "[a-zA-Z]{3,3}[0-9]{4,4}[a-zA-Z]{1,1}", message = "Número de flota inválida")
	private String nroFlota;
	private String nombreBarco;
	
	public int getBarcoId() {
		return barcoId;
	}
	public void setBarcoId(int barcoId) {
		this.barcoId = barcoId;
	}
	public String getNroFlota() {
		return nroFlota;
	}
	public void setNroFlota(String nroFlota) {
		this.nroFlota = nroFlota;
	}
	public String getNombreBarco() {
		return nombreBarco;
	}
	public void setNombreBarco(String nombreBarco) {
		this.nombreBarco = nombreBarco;
	}

}
