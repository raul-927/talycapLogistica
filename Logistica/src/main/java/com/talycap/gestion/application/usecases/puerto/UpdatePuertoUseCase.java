package com.talycap.gestion.application.usecases.puerto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.in.puerto.UpdatePuertoIn;
import com.talycap.gestion.domain.ports.out.PuertoOut;

@Component
public class UpdatePuertoUseCase implements UpdatePuertoIn {
	
	private final PuertoOut puertoOut;
	
	
	public UpdatePuertoUseCase(PuertoOut puertoOut) {
		this.puertoOut = puertoOut;
	}

	@Override
	public Puerto updatePuerto(Puerto puerto) {
		
		return puertoOut.updatePuerto(puerto);
	}

}
