package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Camion;

public interface CamionOut {
	Camion createCamion(Camion camion);
	Camion updateCamion(Camion camion);
	List<Camion> selectCamion(Camion camion);
	boolean deleteCamion(Camion camion);

}
