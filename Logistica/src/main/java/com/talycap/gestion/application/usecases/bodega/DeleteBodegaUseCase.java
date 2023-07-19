package com.talycap.gestion.application.usecases.bodega;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.in.bodega.DeleteBodegaIn;
import com.talycap.gestion.domain.ports.out.BodegaOut;

@Component
public class DeleteBodegaUseCase implements DeleteBodegaIn {
	
	private final BodegaOut bodegaOut;
	
	
	public DeleteBodegaUseCase(BodegaOut bodegaOut) {
		this.bodegaOut = bodegaOut;
	}

	@Override
	public boolean deleteBodega(Bodega bodega) {
		
		return bodegaOut.deleteBodega(bodega);
	}

}
