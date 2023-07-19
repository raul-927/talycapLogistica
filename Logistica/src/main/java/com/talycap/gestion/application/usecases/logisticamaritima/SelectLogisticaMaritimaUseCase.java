package com.talycap.gestion.application.usecases.logisticamaritima;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.ports.in.logisticamaritima.SelectLogisticaMaritimaIn;
import com.talycap.gestion.domain.ports.out.LogisticaMaritimaOut;


@Component
public class SelectLogisticaMaritimaUseCase implements SelectLogisticaMaritimaIn {
	
	private final LogisticaMaritimaOut logisticaMaritimaOut;
	
	
	public SelectLogisticaMaritimaUseCase(LogisticaMaritimaOut logisticaMaritimaOut) {
		this.logisticaMaritimaOut = logisticaMaritimaOut;
	}

	@Override
	public List<LogisticaMaritima> selectLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		
		return logisticaMaritimaOut.selectLogisticaMaritima(logisticaMaritima);
	}

}
