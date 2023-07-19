package com.talycap.gestion.application.usecases.logisticaterrestre;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.in.logisticaterrestre.DeleteLogisticaTerrestreIn;
import com.talycap.gestion.domain.ports.out.LogisticaTerrestreOut;


@Component
public class DeleteLogisticaTerrestreUseCase implements DeleteLogisticaTerrestreIn {
	
	private final LogisticaTerrestreOut logisticaTerrestreOut;
	
	public DeleteLogisticaTerrestreUseCase(LogisticaTerrestreOut logisticaTerrestreOut) {
		this.logisticaTerrestreOut = logisticaTerrestreOut;
	}

	@Override
	public boolean deleteLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		
		return logisticaTerrestreOut.deleteLogisticaTerrestre(logisticaTerrestre);
	}

}
