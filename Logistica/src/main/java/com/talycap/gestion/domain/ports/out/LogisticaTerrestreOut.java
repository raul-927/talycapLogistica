package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.LogisticaTerrestre;

public interface LogisticaTerrestreOut {
	LogisticaTerrestre createLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre);
	LogisticaTerrestre updateLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre);
	List<LogisticaTerrestre> selectLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre);
	boolean deleteLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre);

}
