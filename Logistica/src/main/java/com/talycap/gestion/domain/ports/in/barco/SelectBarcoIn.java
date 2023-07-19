package com.talycap.gestion.domain.ports.in.barco;

import java.util.List;

import com.talycap.gestion.domain.models.Barco;

public interface SelectBarcoIn {
	List<Barco> selectBarco(Barco barco);

}
