package com.talycap.gestion.application.usecases.camion;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.in.camion.DeleteCamionIn;
import com.talycap.gestion.domain.ports.out.CamionOut;

@Component
public class DeleteCamionUseCase implements DeleteCamionIn {
	
	private final CamionOut camionOut;
	
	
	public DeleteCamionUseCase(CamionOut camionOut) {
		this.camionOut = camionOut;
	}

	@Override
	public boolean deleteCamion(Camion camion) {
		
		return camionOut.deleteCamion(camion);
	}

}
