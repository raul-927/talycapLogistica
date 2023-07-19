package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.ports.out.LogisticaMaritimaOut;
import com.talycap.gestion.infrastructure.entitys.LogisticaMaritimaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaMaritimaMapper;
import com.talycap.gestion.infrastructure.rest.mappers.LogisticaMaritimaEntityMapper;

@Component
public class LogisticaMaritimaAdapter implements LogisticaMaritimaOut{
	
	@Autowired
	private LogisticaMaritimaMapper logisticaMaritimaMapper;
	
	@Autowired
	private LogisticaMaritimaEntityMapper logisticaMaritimaEntityMapper;

	@Override
	public LogisticaMaritima createLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		LogisticaMaritimaEntity lEntity = logisticaMaritimaEntityMapper.toLogisticaMaritimaEntity(logisticaMaritima);
		logisticaMaritimaMapper.insert(lEntity);
		
		return logisticaMaritimaEntityMapper.toLogisticaMaritima(lEntity);
	}

	@Override
	public LogisticaMaritima updateLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		LogisticaMaritimaEntity lEntity = logisticaMaritimaEntityMapper.toLogisticaMaritimaEntity(logisticaMaritima);
		logisticaMaritimaMapper.update(lEntity);
		
		return logisticaMaritimaEntityMapper.toLogisticaMaritima(lEntity);
	}

	@Override
	public List<LogisticaMaritima> selectLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		List<LogisticaMaritimaEntity> logisticaMaritimaList = logisticaMaritimaMapper.select(logisticaMaritimaEntityMapper.toLogisticaMaritimaEntity(logisticaMaritima));
		List<LogisticaMaritima> logisticaMaritimaResult = (List<LogisticaMaritima>) logisticaMaritimaEntityMapper.toLogisticasMaritimas(logisticaMaritimaList); 
		return logisticaMaritimaResult;
	}

	@Override
	public boolean deleteLogisticaMaritima(LogisticaMaritima logisticaMaritima) {
		List<LogisticaMaritimaEntity> logisticaMaritimaList = logisticaMaritimaMapper.select(logisticaMaritimaEntityMapper.toLogisticaMaritimaEntity(logisticaMaritima));
		if(!logisticaMaritimaList.isEmpty()) {
			logisticaMaritimaMapper.delete(logisticaMaritimaList.get(0));
			return true;
		}
		return false;
	}

}
