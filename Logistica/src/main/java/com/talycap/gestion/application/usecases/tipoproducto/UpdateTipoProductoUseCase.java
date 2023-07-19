package com.talycap.gestion.application.usecases.tipoproducto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.in.tipoproducto.UpdateTipoProductoIn;
import com.talycap.gestion.domain.ports.out.TipoProductoOut;

@Component
public class UpdateTipoProductoUseCase implements UpdateTipoProductoIn {
	
	private final TipoProductoOut tipoProductoOut;
	
	public UpdateTipoProductoUseCase(TipoProductoOut tipoProductoOut) {
		this.tipoProductoOut = tipoProductoOut;
	}

	@Override
	public TipoProducto updateTipoProducto(TipoProducto tipoProducto) {
		
		return tipoProductoOut.updateTipoProducto(tipoProducto);
	}

}
