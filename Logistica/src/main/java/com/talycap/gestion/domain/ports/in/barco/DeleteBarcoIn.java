package com.talycap.gestion.domain.ports.in.barco;

import com.talycap.gestion.domain.models.Barco;

public interface DeleteBarcoIn {
	
	boolean deleteBarco(Barco barco);

}
