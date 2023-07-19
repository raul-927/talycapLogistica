package com.talycap.gestion.application.usecases.tipoproducto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.in.tipoproducto.CreateTipoProductoIn;
import com.talycap.gestion.domain.ports.out.TipoProductoOut;

@Component
public class CreateTipoProductoUseCase implements CreateTipoProductoIn {
	
	private final TipoProductoOut tipoProductoOut;
	
	public CreateTipoProductoUseCase(TipoProductoOut tipoProductoOut) {
		this.tipoProductoOut = tipoProductoOut;
	}

	@Override
	public TipoProducto createTipoProducto(TipoProducto tipoProducto) {
		
		return tipoProductoOut.createTipoProducto(tipoProducto);
	}

}
