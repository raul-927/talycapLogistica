package com.talycap.gestion.application.usecases.barco;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.in.barco.SelectBarcoIn;
import com.talycap.gestion.domain.ports.out.BarcoOut;

@Component
public class SelectBarcoUseCase implements SelectBarcoIn {
	
	private final BarcoOut BarcoOut;
	
	
	public SelectBarcoUseCase(BarcoOut BarcoOut) {
		this.BarcoOut = BarcoOut;
	}

	@Override
	public List<Barco> selectBarco(Barco barco) {
		
		return BarcoOut.selectBarco(barco);
	}

}
