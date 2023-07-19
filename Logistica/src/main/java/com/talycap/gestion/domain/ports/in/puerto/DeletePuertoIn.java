package com.talycap.gestion.domain.ports.in.puerto;

import com.talycap.gestion.domain.models.Puerto;

public interface DeletePuertoIn {
	boolean deletePuerto(Puerto puerto);
}
