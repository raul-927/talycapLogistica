package com.talycap.gestion.application.usecases.puerto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.in.puerto.CreatePuertoIn;
import com.talycap.gestion.domain.ports.out.PuertoOut;

@Component
public class CreatePuertoUseCase implements CreatePuertoIn {
	
	private final PuertoOut puertoOut;
	
	public CreatePuertoUseCase(PuertoOut puertoOut) {
		this.puertoOut = puertoOut;
	}

	@Override
	public Puerto createPuerto(Puerto puerto) {
		
		return puertoOut.createPuerto(puerto);
	}

}
