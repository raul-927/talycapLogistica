package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.out.BarcoOut;
import com.talycap.gestion.infrastructure.entitys.BarcoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.BarcoMapper;
import com.talycap.gestion.infrastructure.rest.mappers.BarcoEntityMapper;

@Component
public class BarcoAdapter implements BarcoOut {
	
	
	@Autowired
	private BarcoMapper barcoMapper;
	
	@Autowired
	private BarcoEntityMapper barcoEntityMapper;
	

	@Override
	public Barco createBarco(Barco barco) {
		BarcoEntity bEntity = barcoEntityMapper.toBarcoEnity(barco);
		barcoMapper.insert(bEntity);
		return barcoEntityMapper.toBarco(bEntity);
	}

	@Override
	public Barco updateBarco(Barco barco) {
		BarcoEntity bEntity = barcoEntityMapper.toBarcoEnity(barco);
		barcoMapper.update(bEntity);
		return barcoEntityMapper.toBarco(bEntity);
	}

	@Override
	public List<Barco> selectBarco(Barco barco) {
		List<BarcoEntity> barcoEntityResult = barcoMapper.select(barcoEntityMapper.toBarcoEnity(barco));
		List<Barco> barcoResult = (List<Barco> )barcoEntityMapper.toBarcos(barcoEntityResult);
		return barcoResult;
	}

	@Override
	public boolean deleteBarco(Barco barco) {
		List<BarcoEntity> barcoEntityResult = barcoMapper.select(barcoEntityMapper.toBarcoEnity(barco));
		if(!barcoEntityResult.isEmpty()) {
			barcoMapper.delete(barcoEntityResult.get(0));
			return true;
		}
		return false;
	}

}
