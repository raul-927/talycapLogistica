package com.talycap.gestion.domain.models;

import javax.validation.constraints.Pattern;

public class Camion {
	private int camionId;
	
	@Pattern(regexp = "[a-zA-Z]{3,3}[0-9]{3,3}", message = "Placa inválida")
	private String placa;
	
	private String modelo;
	private String marca;

	public int getCamionId() {
		return camionId;
	}

	public void setCamionId(int camionId) {
		this.camionId = camionId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	

}
