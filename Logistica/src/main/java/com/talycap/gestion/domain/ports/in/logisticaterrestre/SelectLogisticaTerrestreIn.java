package com.talycap.gestion.domain.ports.in.logisticaterrestre;

import java.util.List;

import com.talycap.gestion.domain.models.LogisticaTerrestre;

public interface SelectLogisticaTerrestreIn {
	List<LogisticaTerrestre> selectLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre);
}
