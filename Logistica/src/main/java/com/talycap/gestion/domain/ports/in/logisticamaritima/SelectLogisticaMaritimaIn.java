package com.talycap.gestion.domain.ports.in.logisticamaritima;

import java.util.List;

import com.talycap.gestion.domain.models.LogisticaMaritima;

public interface SelectLogisticaMaritimaIn {
	
	List<LogisticaMaritima> selectLogisticaMaritima(LogisticaMaritima logisticaMaritima);

}
