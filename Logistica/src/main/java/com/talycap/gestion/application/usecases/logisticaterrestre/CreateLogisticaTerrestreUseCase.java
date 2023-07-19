package com.talycap.gestion.application.usecases.logisticaterrestre;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.in.logisticaterrestre.CreateLogisticaTerrestreIn;
import com.talycap.gestion.domain.ports.out.LogisticaTerrestreOut;


@Component
public class CreateLogisticaTerrestreUseCase implements CreateLogisticaTerrestreIn {
	
	private final LogisticaTerrestreOut logisticaTerrestreOut;
	
	
	public CreateLogisticaTerrestreUseCase(LogisticaTerrestreOut logisticaTerrestreOut) {
		this.logisticaTerrestreOut = logisticaTerrestreOut;
	}

	@Override
	public LogisticaTerrestre createLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		
		return logisticaTerrestreOut.createLogisticaTerrestre(logisticaTerrestre);
	}

}
