package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.out.BodegaOut;
import com.talycap.gestion.infrastructure.entitys.BodegaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.BodegaMapper;
import com.talycap.gestion.infrastructure.rest.mappers.BodegaEntityMapper;

@Component
public class BodegaAdapter implements BodegaOut {
	
	@Autowired
	private BodegaMapper bodegaMapper;
	
	@Autowired
	private BodegaEntityMapper bodegaEntityMapper;

	@Override
	public Bodega createBodega(Bodega bodega) {
		BodegaEntity bEntity = bodegaEntityMapper.toBodegaEnity(bodega);
		bodegaMapper.insert(bEntity);
		
		return bodegaEntityMapper.toBodega(bEntity);
	}

	@Override
	public Bodega updateBodega(Bodega bodega) {
		BodegaEntity bEntity = bodegaEntityMapper.toBodegaEnity(bodega);
		bodegaMapper.update(bEntity);
		
		return bodegaEntityMapper.toBodega(bEntity);
	}

	@Override
	public List<Bodega> selectBodega(Bodega bodega) {
		List<BodegaEntity> bodegaEntityResult = bodegaMapper.select(bodegaEntityMapper.toBodegaEnity(bodega));
		List<Bodega> bodegaResult = (List<Bodega> )bodegaEntityMapper.toBodegas(bodegaEntityResult);
		return bodegaResult;
	}

	@Override
	public boolean deleteBodega(Bodega bodega) {
		List<BodegaEntity> bodegaEntityResult = bodegaMapper.select(bodegaEntityMapper.toBodegaEnity(bodega));
		if(!bodegaEntityResult.isEmpty()) {
			bodegaMapper.delete(bodegaEntityResult.get(0));
			return true;
		}
		return false;
	}

}
