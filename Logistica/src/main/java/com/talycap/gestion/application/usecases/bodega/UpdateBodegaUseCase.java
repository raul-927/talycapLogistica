package com.talycap.gestion.application.usecases.bodega;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.in.bodega.UpdateBodegaIn;
import com.talycap.gestion.domain.ports.out.BodegaOut;

@Component
public class UpdateBodegaUseCase implements UpdateBodegaIn {
	
	private final BodegaOut bodegaOut;
	
	
	public UpdateBodegaUseCase(BodegaOut bodegaOut) {
		this.bodegaOut = bodegaOut;
	}

	@Override
	public Bodega updateBodega(Bodega bodega) {
		
		return bodegaOut.updateBodega(bodega);
	}

}
