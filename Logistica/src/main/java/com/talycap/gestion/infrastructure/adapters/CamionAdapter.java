package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.domain.ports.out.CamionOut;
import com.talycap.gestion.infrastructure.entitys.CamionEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.CamionMapper;
import com.talycap.gestion.infrastructure.rest.mappers.CamionEntityMapper;

@Component
public class CamionAdapter implements CamionOut {
	
	@Autowired
	private final CamionMapper camionMapper;
	
	@Autowired
	private final CamionEntityMapper camionEntityMapper;
	
	
	public CamionAdapter(CamionMapper camionMapper, CamionEntityMapper camionEntityMapper) {
		this.camionMapper = camionMapper;
		this.camionEntityMapper = camionEntityMapper;
	}

	@Override
	public Camion createCamion(Camion camion) {
		CamionEntity cEntity = camionEntityMapper.toCamionEnity(camion);
		camionMapper.insert(cEntity);
		return camionEntityMapper.toCamion(cEntity);
	}

	@Override
	public Camion updateCamion(Camion camion) {
		CamionEntity cEntity = camionEntityMapper.toCamionEnity(camion);
		camionMapper.update(cEntity);
		return camionEntityMapper.toCamion(cEntity);
	}

	@Override
	public List<Camion> selectCamion(Camion camion) {
		List<CamionEntity> camionEntityResult = camionMapper.select(camionEntityMapper.toCamionEnity(camion));
		List<Camion> camionResult = (List<Camion>) camionEntityMapper.toCamiones(camionEntityResult);
				
		return camionResult;
	}

	@Override
	public boolean deleteCamion(Camion camion) {
		List<CamionEntity> camionEntityListResult = camionMapper.select(camionEntityMapper.toCamionEnity(camion));
		if(!camionEntityListResult.isEmpty()) {
			camionMapper.delete(camionEntityListResult.get(0));
			return true;
		}
		return false;
	}

}
