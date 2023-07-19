package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.in.logistica.CreateLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.DeleteLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.SelectLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.UpdateLogisticaIn;
import com.talycap.gestion.domain.ports.in.logisticamaritima.CreateLogisticaMaritimaIn;
import com.talycap.gestion.domain.ports.in.logisticaterrestre.CreateLogisticaTerrestreIn;

@Service
public class LogisticaServiceImpl implements LogisticaService {
	
	
	private final CreateLogisticaIn createLogisticaIn; 
	private final CreateLogisticaMaritimaIn createLogisticaMaritimaIn;
	private final CreateLogisticaTerrestreIn createLogisticaTerrestreIn;
	private final UpdateLogisticaIn updateLogisticaIn; 
	private final SelectLogisticaIn selectLogisticaIn; 
	private final DeleteLogisticaIn deleteLogisticaIn;
	
	public LogisticaServiceImpl(CreateLogisticaIn createLogisticaIn, 
			CreateLogisticaMaritimaIn createLogisticaMaritimaIn, 
			CreateLogisticaTerrestreIn createLogisticaTerrestreIn, 
			UpdateLogisticaIn updateLogisticaIn,
			SelectLogisticaIn selectLogisticaIn, 
			DeleteLogisticaIn deleteLogisticaIn) {
		
		this.createLogisticaIn = createLogisticaIn;
		this.createLogisticaMaritimaIn = createLogisticaMaritimaIn;
		this.createLogisticaTerrestreIn = createLogisticaTerrestreIn;
		this.updateLogisticaIn = updateLogisticaIn;
		this.selectLogisticaIn = selectLogisticaIn;
		this.deleteLogisticaIn = deleteLogisticaIn;
	}

	@Override
	public Logistica createLogistica(Logistica logistica) {
		if(logistica.getLogisticaMaritima()!= null) {
			LogisticaMaritima lMaritima = createLogisticaMaritimaIn.createLogisticaMaritima(logistica.getLogisticaMaritima());
			logistica.setLogisticaMaritima(lMaritima);
		}
		else if(logistica.getLogisticaTerrestre()!= null) {
			LogisticaTerrestre lTerrestre = createLogisticaTerrestreIn.createLogisticaTerrestre(logistica.getLogisticaTerrestre());
			logistica.setLogisticaTerrestre(lTerrestre);
		}
		return createLogisticaIn.createLogistica(logistica);
	}

	@Override
	public Logistica updateLogistica(Logistica logistica) {
		
		return updateLogisticaIn.updateLogistica(logistica);
	}

	@Override
	public List<Logistica> selectLogistica(Logistica logistica) {
		
		return selectLogisticaIn.selectLogistica(logistica);
	}

	@Override
	public boolean deleteLogistica(Logistica logistica) {
		
		return deleteLogisticaIn.deleteLogistica(logistica);
	}

}
