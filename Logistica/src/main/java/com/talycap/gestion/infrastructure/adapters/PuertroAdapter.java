package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.out.PuertoOut;
import com.talycap.gestion.infrastructure.entitys.PuertoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.PuertoMapper;
import com.talycap.gestion.infrastructure.rest.mappers.PuertoEntityMapper;

@Component
public class PuertroAdapter implements PuertoOut {
	
	@Autowired
	private PuertoMapper puertoMapper;
	
	@Autowired
	private PuertoEntityMapper puertoEntityMapper;

	@Override
	public Puerto createPuerto(Puerto puerto) {
		PuertoEntity pEntity = puertoEntityMapper.toPuertoEnity(puerto);
		puertoMapper.insert(pEntity);
		
		return puertoEntityMapper.toPuerto(pEntity);
	}

	@Override
	public Puerto updatePuerto(Puerto puerto) {
		PuertoEntity pEntity = puertoEntityMapper.toPuertoEnity(puerto);
		puertoMapper.update(pEntity);
		
		return puertoEntityMapper.toPuerto(pEntity);
	}

	@Override
	public List<Puerto> selectPuerto(Puerto puerto) {
		List<PuertoEntity> puertoEntityList = puertoMapper.select(puertoEntityMapper.toPuertoEnity(puerto));
		List<Puerto> puertoResult = (List<Puerto>) puertoEntityMapper.toPuertos(puertoEntityList); 
		return puertoResult;
	}

	@Override
	public boolean deletePuerto(Puerto puerto) {
		List<PuertoEntity> puertoEntityList = puertoMapper.select(puertoEntityMapper.toPuertoEnity(puerto));
		if(!puertoEntityList.isEmpty()) {
			puertoMapper.delete(puertoEntityList.get(0));
			return true;
		}
		
		return false;
	}

}
