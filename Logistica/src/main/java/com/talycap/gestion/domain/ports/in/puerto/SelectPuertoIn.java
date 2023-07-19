package com.talycap.gestion.domain.ports.in.puerto;

import java.util.List;

import com.talycap.gestion.domain.models.Puerto;

public interface SelectPuertoIn {
	List<Puerto> selectPuerto(Puerto puerto);
}
