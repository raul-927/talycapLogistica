package com.talycap.gestion.application.usecases.camion;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.in.camion.SelectCamionIn;
import com.talycap.gestion.domain.ports.out.CamionOut;

@Component
public class SelectCamionUseCase implements SelectCamionIn {
	
	private final CamionOut camionOut;
	
	public SelectCamionUseCase(CamionOut camionOut) {
		this.camionOut = camionOut;
	}

	@Override
	public List<Camion> selectCamion(Camion camion) {
		
		return camionOut.selectCamion(camion);
	}

}
