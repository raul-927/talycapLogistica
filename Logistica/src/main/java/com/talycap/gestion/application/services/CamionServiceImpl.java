package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.in.camion.CreateCamionIn;
import com.talycap.gestion.domain.ports.in.camion.DeleteCamionIn;
import com.talycap.gestion.domain.ports.in.camion.SelectCamionIn;
import com.talycap.gestion.domain.ports.in.camion.UpdateCamionIn;

@Service
public class CamionServiceImpl implements CamionService{
	
	private final CreateCamionIn createCamionIn; 
	private final UpdateCamionIn updateCamionIn; 
	private final SelectCamionIn selectCamionIn; 
	private final DeleteCamionIn deleteCamionIn;
	
	
	public CamionServiceImpl(CreateCamionIn createCamionIn, UpdateCamionIn updateCamionIn, SelectCamionIn selectCamionIn, DeleteCamionIn deleteCamionIn) {
		this.createCamionIn = createCamionIn;
		this.updateCamionIn = updateCamionIn;
		this.selectCamionIn = selectCamionIn;
		this.deleteCamionIn = deleteCamionIn;
	}

	@Override
	public Camion createCamion(Camion camion) {
		
		return createCamionIn.createCamion(camion);
	}

	@Override
	public Camion updateCamion(Camion camion) {
		
		return updateCamionIn.updateCamion(camion);
	}

	@Override
	public List<Camion> selectCamion(Camion camion) {
		
		return selectCamionIn.selectCamion(camion);
	}

	@Override
	public boolean deleteCamion(Camion camion) {
		
		return deleteCamionIn.deleteCamion(camion);
	}

}
