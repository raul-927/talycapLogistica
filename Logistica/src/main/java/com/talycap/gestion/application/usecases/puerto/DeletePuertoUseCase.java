package com.talycap.gestion.application.usecases.puerto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.in.puerto.DeletePuertoIn;
import com.talycap.gestion.domain.ports.out.PuertoOut;

@Component
public class DeletePuertoUseCase implements DeletePuertoIn {
	
	private final PuertoOut puertoOut;
	
	public DeletePuertoUseCase(PuertoOut puertoOut) {
		this.puertoOut= puertoOut;
	}

	@Override
	public boolean deletePuerto(Puerto puerto) {
		
		return puertoOut.deletePuerto(puerto);
	}

}
