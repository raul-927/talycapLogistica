package com.talycap.gestion.application.usecases.logistica;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.ports.in.logistica.SelectLogisticaIn;
import com.talycap.gestion.domain.ports.out.LogisticaOut;

@Component
public class SelectLogisticaUseCase implements SelectLogisticaIn {
	
	private final LogisticaOut logisticaOut;
	
	
	public SelectLogisticaUseCase(LogisticaOut logisticaOut) {
		this.logisticaOut = logisticaOut;
	}

	@Override
	public List<Logistica> selectLogistica(Logistica logistica) {

		return logisticaOut.selectLogistica(logistica);
	}

}
