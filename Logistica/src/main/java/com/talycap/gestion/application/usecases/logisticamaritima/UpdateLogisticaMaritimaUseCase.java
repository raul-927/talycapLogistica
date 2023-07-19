package com.talycap.gestion.application.usecases.logisticamaritima;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.ports.in.logisticamaritima.UpdateLogisticaMaritimaIn;
import com.talycap.gestion.domain.ports.out.LogisticaMaritimaOut;


@Component
public class UpdateLogisticaMaritimaUseCase implements UpdateLogisticaMaritimaIn {
	
	private final LogisticaMaritimaOut logisticaMaritimaOut;
	
	
	public UpdateLogisticaMaritimaUseCase(LogisticaMaritimaOut logisticaMaritimaOut) {
		this.logisticaMaritimaOut = logisticaMaritimaOut;
	}


	@Override
	public LogisticaMaritima updateLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		
		return logisticaMaritimaOut.updateLogisticaMaritima(logisticaMaritima);
	}

}
