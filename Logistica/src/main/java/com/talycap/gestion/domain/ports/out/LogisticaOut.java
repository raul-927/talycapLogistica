package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Logistica;

public interface LogisticaOut {
	Logistica createLogistica(Logistica logistica);
	Logistica updateLogistica(Logistica logistica);
	List<Logistica> selectLogistica(Logistica logistica);
	boolean deleteLogistica(Logistica logistica);

}
