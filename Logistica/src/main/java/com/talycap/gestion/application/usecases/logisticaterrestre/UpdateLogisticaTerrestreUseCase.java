package com.talycap.gestion.application.usecases.logisticaterrestre;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.in.logisticaterrestre.UpdateLogisticaTerrestreIn;
import com.talycap.gestion.domain.ports.out.LogisticaTerrestreOut;


@Component
public class UpdateLogisticaTerrestreUseCase implements UpdateLogisticaTerrestreIn {
	
	private final LogisticaTerrestreOut logisticaTerrestreOut;
	
	public UpdateLogisticaTerrestreUseCase(LogisticaTerrestreOut logisticaTerrestreOut) {
		this.logisticaTerrestreOut = logisticaTerrestreOut;
	}

	@Override
	public LogisticaTerrestre updateLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		
		return logisticaTerrestreOut.updateLogisticaTerrestre(logisticaTerrestre);
	}

}
