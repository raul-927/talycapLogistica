package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Puerto;

public interface PuertoOut {
	Puerto createPuerto(Puerto puerto);
	Puerto updatePuerto(Puerto puerto);
	List<Puerto> selectPuerto(Puerto puerto);
	boolean deletePuerto(Puerto puerto);
}
