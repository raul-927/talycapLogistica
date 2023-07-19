package com.talycap.gestion.application.usecases.logistica;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.ports.in.logistica.DeleteLogisticaIn;
import com.talycap.gestion.domain.ports.out.LogisticaOut;

@Component
public class DeleteLogisticaUseCase implements DeleteLogisticaIn {
	
	private final LogisticaOut logisticaOut;
	
	
	public DeleteLogisticaUseCase(LogisticaOut logisticaOut) {
		this.logisticaOut = logisticaOut;
	}

	@Override
	public boolean deleteLogistica(Logistica logistica) {
		
		return logisticaOut.deleteLogistica(logistica);
	}

}
