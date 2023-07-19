package com.talycap.gestion.application.usecases.logisticamaritima;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.ports.in.logisticamaritima.DeleteLogisticaMaritimaIn;
import com.talycap.gestion.domain.ports.out.LogisticaMaritimaOut;


@Component
public class DeleteLogisticaMaritimaUseCase implements DeleteLogisticaMaritimaIn {
	
	private final LogisticaMaritimaOut logisticaMaritimaOut;
	
	
	public DeleteLogisticaMaritimaUseCase(LogisticaMaritimaOut logisticaMaritimaOut) {
		this.logisticaMaritimaOut = logisticaMaritimaOut;
	}

	@Override
	public boolean deleteLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		
		return logisticaMaritimaOut.deleteLogisticaMaritima(logisticaMaritima);
	}

}
