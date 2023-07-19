package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Barco;

public interface BarcoOut {
	Barco createBarco(Barco barco);
	Barco updateBarco(Barco barco);
	List<Barco> selectBarco(Barco barco);
	boolean deleteBarco(Barco barco);

}
