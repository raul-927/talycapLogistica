package com.talycap.gestion.application.usecases.bodega;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.in.bodega.SelectBodegaIn;
import com.talycap.gestion.domain.ports.out.BodegaOut;

@Component
public class SelectBodegaUseCase implements SelectBodegaIn {
	
	private final BodegaOut bodegaOut;
	
	
	public SelectBodegaUseCase(BodegaOut bodegaOut) {
		this.bodegaOut = bodegaOut;
	}

	@Override
	public List<Bodega> selectBodega(Bodega bodega) {
		
		return bodegaOut.selectBodega(bodega);
	}

}
