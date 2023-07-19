package com.talycap.gestion.application.usecases.bodega;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.in.bodega.CreateBodegaIn;
import com.talycap.gestion.domain.ports.out.BodegaOut;

@Component
public class CreateBodegaUseCase implements CreateBodegaIn {
	
	private final BodegaOut bodegaOut;
	
	public CreateBodegaUseCase(BodegaOut bodegaOut) {
		this.bodegaOut = bodegaOut;
	}

	@Override
	public Bodega createBodega(Bodega bodega) {
		
		return bodegaOut.createBodega(bodega);
	}

}
