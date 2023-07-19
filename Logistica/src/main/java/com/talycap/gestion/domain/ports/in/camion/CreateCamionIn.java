package com.talycap.gestion.domain.ports.in.camion;

import com.talycap.gestion.domain.models.Camion;

public interface CreateCamionIn {
	
	Camion createCamion(Camion camion);

}
