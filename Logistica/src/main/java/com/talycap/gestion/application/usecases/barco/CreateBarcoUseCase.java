package com.talycap.gestion.application.usecases.barco;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.in.barco.CreateBarcoIn;
import com.talycap.gestion.domain.ports.out.BarcoOut;

@Component
public class CreateBarcoUseCase implements CreateBarcoIn {
	
	private final BarcoOut BarcoOut;
	
	public CreateBarcoUseCase(BarcoOut BarcoOut) {
		this.BarcoOut = BarcoOut;
	}

	@Override
	public Barco createBarco(Barco barco) {
		return BarcoOut.createBarco(barco);
	}

}
