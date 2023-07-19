package com.talycap.gestion.application.usecases.barco;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.in.barco.DeleteBarcoIn;
import com.talycap.gestion.domain.ports.out.BarcoOut;

@Component
public class DeleteBarcoUseCase implements DeleteBarcoIn {
	
	private final BarcoOut BarcoOut;
	
	public DeleteBarcoUseCase(BarcoOut BarcoOut) {
		this.BarcoOut = BarcoOut;
	}

	@Override
	public boolean deleteBarco(Barco barco) {
		
		return BarcoOut.deleteBarco(barco);
	}

}
