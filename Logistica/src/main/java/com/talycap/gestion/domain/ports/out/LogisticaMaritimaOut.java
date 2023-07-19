package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.LogisticaMaritima;

public interface LogisticaMaritimaOut {
	
	LogisticaMaritima createLogisticaMaritima(LogisticaMaritima logisticaMaritima);
	LogisticaMaritima updateLogisticaMaritima(LogisticaMaritima logisticaMaritima);
	List<LogisticaMaritima> selectLogisticaMaritima(LogisticaMaritima logisticaMaritima);
	boolean deleteLogisticaMaritima(LogisticaMaritima logisticaMaritima);

}
