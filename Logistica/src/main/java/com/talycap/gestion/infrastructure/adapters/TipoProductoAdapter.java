package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.out.TipoProductoOut;
import com.talycap.gestion.infrastructure.entitys.TipoProductoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.TipoProductoMapper;
import com.talycap.gestion.infrastructure.rest.mappers.TipoProductoEntityMapper;


@Component
public class TipoProductoAdapter implements TipoProductoOut {
	
	@Autowired
	private TipoProductoMapper tipoProductoMapper;
	
	@Autowired
	private TipoProductoEntityMapper tipoProductoEntityMapper;

	@Override
	public TipoProducto createTipoProducto(TipoProducto tipoProducto) {
		TipoProductoEntity tEntity = tipoProductoEntityMapper.toTipoProductoEntity(tipoProducto);
		tipoProductoMapper.insert(tEntity);
		
		return tipoProductoEntityMapper.toTipoProducto(tEntity);
	}

	@Override
	public TipoProducto updateTipoProducto(TipoProducto tipoProducto) {
		TipoProductoEntity tEntity = tipoProductoEntityMapper.toTipoProductoEntity(tipoProducto);
		tipoProductoMapper.update(tEntity);
		
		return tipoProductoEntityMapper.toTipoProducto(tEntity);
	}

	@Override
	public List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto) {
		List<TipoProductoEntity> tipoProductoEntityList = tipoProductoMapper.select(tipoProductoEntityMapper.toTipoProductoEntity(tipoProducto));
		List<TipoProducto> tipoProductoResult = (List<TipoProducto>)tipoProductoEntityMapper.toTipoProductos(tipoProductoEntityList);
		return tipoProductoResult;
	}

	@Override
	public boolean deleteTipoProducto(TipoProducto tipoProducto) {
		List<TipoProductoEntity> tipoProductoEntityList = tipoProductoMapper.select(tipoProductoEntityMapper.toTipoProductoEntity(tipoProducto));
		if(!tipoProductoEntityList.isEmpty()) {
			tipoProductoMapper.delete(tipoProductoEntityList.get(0));
			return true;
		}
		return false;
	}

}
