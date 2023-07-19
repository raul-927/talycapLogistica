package com.talycap.gestion.application.usecases.barco;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.in.barco.UpdateBarcoIn;
import com.talycap.gestion.domain.ports.out.BarcoOut;

@Component
public class UpdateBarcoUseCase implements UpdateBarcoIn {
	
	private final BarcoOut BarcoOut;
	
	public UpdateBarcoUseCase(BarcoOut BarcoOut) {
		this.BarcoOut = BarcoOut;
	}

	@Override
	public Barco updateBarco(Barco barco) {
		
		return BarcoOut.updateBarco(barco);
	}

}
