package com.talycap.gestion.application.usecases.logistica;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.ports.in.logistica.UpdateLogisticaIn;
import com.talycap.gestion.domain.ports.out.LogisticaOut;

@Component
public class UpdateLogisticaUseCase implements UpdateLogisticaIn {
	
	private final LogisticaOut logisticaOut;
	
	
	public UpdateLogisticaUseCase(LogisticaOut logisticaOut) {
		this.logisticaOut = logisticaOut;
	}

	@Override
	public Logistica updateLogistica(Logistica logistica) {
		
		return logisticaOut.updateLogistica(logistica);
	}

}
