package com.talycap.gestion.domain.ports.in.camion;

import java.util.List;

import com.talycap.gestion.domain.models.Camion;

public interface SelectCamionIn {
	
	List<Camion> selectCamion(Camion camion);

}
