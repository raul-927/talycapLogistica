package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.ports.out.LogisticaOut;
import com.talycap.gestion.infrastructure.entitys.LogisticaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaMapper;
import com.talycap.gestion.infrastructure.rest.mappers.LogisticaEntityMapper;


@Component
public class LogisticaAdapter implements LogisticaOut {
	
	@Autowired
	private LogisticaMapper logisticaMapper;
	
	@Autowired
	private LogisticaEntityMapper logisticaEntityMapper;

	@Override
	public Logistica createLogistica(Logistica logistica) {
		LogisticaEntity lEntity = logisticaEntityMapper.toLogisticaEntity(logistica);
		logisticaMapper.insert(lEntity);
		return logisticaEntityMapper.toLogistica(lEntity);
	}

	@Override
	public Logistica updateLogistica(Logistica logistica) {
		LogisticaEntity lEntity = logisticaEntityMapper.toLogisticaEntity(logistica);
		logisticaMapper.update(lEntity);
		return logisticaEntityMapper.toLogistica(lEntity);
	}

	@Override
	public List<Logistica> selectLogistica(Logistica logistica) {
		List<LogisticaEntity> logisticaEntityList = logisticaMapper.select(logisticaEntityMapper.toLogisticaEntity(logistica));
		List<Logistica> logisticaResult = (List<Logistica>) logisticaEntityMapper.toLogisticas(logisticaEntityList);  
		return logisticaResult;
	}

	@Override
	public boolean deleteLogistica(Logistica logistica) {
		List<LogisticaEntity> logisticaEntityList = logisticaMapper.select(logisticaEntityMapper.toLogisticaEntity(logistica));
		if(!logisticaEntityList.isEmpty()) {
			logisticaMapper.delete(logisticaEntityList.get(0));
			return true;
		}
		return false;
	}

}
