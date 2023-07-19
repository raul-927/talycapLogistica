package com.talycap.gestion.application.usecases.camion;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.in.camion.CreateCamionIn;
import com.talycap.gestion.domain.ports.out.CamionOut;

@Component
public class CreateCamionUseCase implements CreateCamionIn {
	
	private final CamionOut camionOut;
	
	public CreateCamionUseCase(CamionOut camionOut) {
		this.camionOut = camionOut;
	}

	@Override
	public Camion createCamion(Camion camion) {
		
		return camionOut.createCamion(camion);
	}

}
