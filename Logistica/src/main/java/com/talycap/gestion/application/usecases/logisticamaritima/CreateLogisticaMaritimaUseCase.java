package com.talycap.gestion.application.usecases.logisticamaritima;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.ports.in.logisticamaritima.CreateLogisticaMaritimaIn;
import com.talycap.gestion.domain.ports.out.LogisticaMaritimaOut;


@Component
public class CreateLogisticaMaritimaUseCase implements CreateLogisticaMaritimaIn{
	
	private final LogisticaMaritimaOut logisticaMaritimaOut;
	
	public CreateLogisticaMaritimaUseCase(LogisticaMaritimaOut logisticaMaritimaOut) {
		this.logisticaMaritimaOut = logisticaMaritimaOut;
	}

	@Override
	public LogisticaMaritima createLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		
		return logisticaMaritimaOut.createLogisticaMaritima(logisticaMaritima);
	}

}
