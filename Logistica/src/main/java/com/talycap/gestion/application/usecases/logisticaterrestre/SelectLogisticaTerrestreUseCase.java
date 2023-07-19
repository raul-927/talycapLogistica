package com.talycap.gestion.application.usecases.logisticaterrestre;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.in.logisticaterrestre.SelectLogisticaTerrestreIn;
import com.talycap.gestion.domain.ports.out.LogisticaTerrestreOut;


@Component
public class SelectLogisticaTerrestreUseCase implements SelectLogisticaTerrestreIn {
	
	private final LogisticaTerrestreOut logisticaTerrestreOut;
	
	public SelectLogisticaTerrestreUseCase(LogisticaTerrestreOut logisticaTerrestreOut) {
		this.logisticaTerrestreOut = logisticaTerrestreOut;
	}

	@Override
	public List<LogisticaTerrestre> selectLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		
		return logisticaTerrestreOut.selectLogisticaTerrestre(logisticaTerrestre);
	}

}
