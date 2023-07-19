package com.talycap.gestion.application.usecases.camion;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.in.camion.UpdateCamionIn;
import com.talycap.gestion.domain.ports.out.CamionOut;

@Component
public class UpdateCamionUseCase implements UpdateCamionIn {
	
	private final CamionOut camionOut;
	
	public UpdateCamionUseCase(CamionOut camionOut) {
		this.camionOut = camionOut;
	}

	@Override
	public Camion updateCamion(Camion camion) {
		
		return camionOut.updateCamion(camion);
	}

}
