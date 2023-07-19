package com.talycap.gestion.application.usecases.tipoproducto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.in.tipoproducto.SelectTipoProductoIn;
import com.talycap.gestion.domain.ports.out.TipoProductoOut;

@Component
public class SelectTipoProductoUseCase implements SelectTipoProductoIn {
	
	private final TipoProductoOut tipoProductoOut;
	
	
	public SelectTipoProductoUseCase(TipoProductoOut tipoProductoOut) {
		this.tipoProductoOut = tipoProductoOut;
	}

	@Override
	public List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto) {
		
		return tipoProductoOut.selectTipoProducto(tipoProducto);
	}

}
