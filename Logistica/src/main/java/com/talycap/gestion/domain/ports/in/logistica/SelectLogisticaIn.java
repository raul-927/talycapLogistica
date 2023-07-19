package com.talycap.gestion.domain.ports.in.logistica;

import java.util.List;

import com.talycap.gestion.domain.models.Logistica;

public interface SelectLogisticaIn {
	List<Logistica> selectLogistica(Logistica logistica);

}
