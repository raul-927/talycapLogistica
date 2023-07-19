package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.in.tipoproducto.CreateTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.DeleteTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.SelectTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.UpdateTipoProductoIn;


@Service
public class TipoProductoServiceImpl implements TipoProductoService {
	
	
	private final CreateTipoProductoIn createTipoProductoIn; 
	private final UpdateTipoProductoIn updateTipoProductoIn; 
	private final SelectTipoProductoIn selectTipoProductoIn; 
	private final DeleteTipoProductoIn deleteTipoProductoIn;
	
	
	public TipoProductoServiceImpl(CreateTipoProductoIn createTipoProductoIn, UpdateTipoProductoIn updateTipoProductoIn, SelectTipoProductoIn selectTipoProductoIn, DeleteTipoProductoIn deleteTipoProductoIn) {
		this.createTipoProductoIn = createTipoProductoIn;
		this.updateTipoProductoIn = updateTipoProductoIn;
		this.selectTipoProductoIn = selectTipoProductoIn;
		this.deleteTipoProductoIn = deleteTipoProductoIn;
	}

	@Override
	public TipoProducto createTipoProducto(TipoProducto tipoProducto) {
		
		return createTipoProductoIn.createTipoProducto(tipoProducto);
	}

	@Override
	public TipoProducto updateTipoProducto(TipoProducto tipoProducto) {
		
		return updateTipoProductoIn.updateTipoProducto(tipoProducto);
	}

	@Override
	public List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto) {
		
		return selectTipoProductoIn.selectTipoProducto(tipoProducto);
	}

	@Override
	public boolean deleteTipoProducto(TipoProducto tipoProducto) {
		
		return deleteTipoProductoIn.deleteTipoProducto(tipoProducto);
	}

}
