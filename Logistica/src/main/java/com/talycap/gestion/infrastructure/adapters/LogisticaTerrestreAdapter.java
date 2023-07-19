package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.domain.ports.out.LogisticaTerrestreOut;
import com.talycap.gestion.infrastructure.entitys.LogisticaTerrestreEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaTerrestreMapper;
import com.talycap.gestion.infrastructure.rest.mappers.LogisticaTerrestreEntityMapper;


@Component
public class LogisticaTerrestreAdapter implements LogisticaTerrestreOut{
	
	@Autowired
	private LogisticaTerrestreMapper logisticaTerrestreMapper;
	
	@Autowired
	private LogisticaTerrestreEntityMapper logisticaTerrestreEntityMapper;

	@Override
	public LogisticaTerrestre createLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		LogisticaTerrestreEntity lEntity = logisticaTerrestreEntityMapper.toLogisticaTerrestreEntity(logisticaTerrestre);
		logisticaTerrestreMapper.insert(lEntity);
		
		return logisticaTerrestreEntityMapper.toLogisticaTerrestre(lEntity);
	}

	@Override
	public LogisticaTerrestre updateLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		LogisticaTerrestreEntity lEntity = logisticaTerrestreEntityMapper.toLogisticaTerrestreEntity(logisticaTerrestre);
		logisticaTerrestreMapper.update(lEntity);
		
		return logisticaTerrestreEntityMapper.toLogisticaTerrestre(lEntity);
	}

	@Override
	public List<LogisticaTerrestre> selectLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		List<LogisticaTerrestreEntity> logisticaTerrestreEntityList = logisticaTerrestreMapper.select(logisticaTerrestreEntityMapper.toLogisticaTerrestreEntity(logisticaTerrestre));
		List<LogisticaTerrestre> logisticaTerrestreResult = (List<LogisticaTerrestre>) logisticaTerrestreEntityMapper.toLogisticasTerrestres(logisticaTerrestreEntityList);
		
		return logisticaTerrestreResult;
	}

	@Override
	public boolean deleteLogisticaTerrestre(LogisticaTerrestre logisticaTerrestre) {
		List<LogisticaTerrestreEntity> logisticaTerrestreEntityList = logisticaTerrestreMapper.select(logisticaTerrestreEntityMapper.toLogisticaTerrestreEntity(logisticaTerrestre));
		if(!logisticaTerrestreEntityList.isEmpty()) {
			logisticaTerrestreMapper.delete(logisticaTerrestreEntityList.get(0));
			return true;
		}
		return false;
	}

}
