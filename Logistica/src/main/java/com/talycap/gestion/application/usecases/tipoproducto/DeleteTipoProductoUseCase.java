package com.talycap.gestion.application.usecases.tipoproducto;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.domain.ports.in.tipoproducto.DeleteTipoProductoIn;
import com.talycap.gestion.domain.ports.out.TipoProductoOut;

@Component
public class DeleteTipoProductoUseCase implements DeleteTipoProductoIn {
	
	private final TipoProductoOut tipoProductoOut;
	
	public DeleteTipoProductoUseCase(TipoProductoOut tipoProductoOut) {
		this.tipoProductoOut = tipoProductoOut;
	}

	@Override
	public boolean deleteTipoProducto(TipoProducto tipoProducto) {
		
		return tipoProductoOut.deleteTipoProducto(tipoProducto);
	}

}
