package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.domain.ports.in.bodega.CreateBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.DeleteBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.SelectBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.UpdateBodegaIn;

@Service
public class BodegaServiceImpl implements BodegaService {
	private final CreateBodegaIn createBodegaIn; 
	private final UpdateBodegaIn updateBodegaIn;
	private final SelectBodegaIn selectBodegaIn; 
	private final DeleteBodegaIn deleteBodegaIn;
	
	
	public BodegaServiceImpl(CreateBodegaIn createBodegaIn, UpdateBodegaIn updateBodegaIn, 
			SelectBodegaIn selectBodegaIn, DeleteBodegaIn deleteBodegaIn) {
		this.createBodegaIn = createBodegaIn;
		this.updateBodegaIn = updateBodegaIn;
		this.selectBodegaIn = selectBodegaIn;
		this.deleteBodegaIn = deleteBodegaIn;
		
	}

	@Override
	public Bodega createBodega(Bodega bodega) {
		
		return createBodegaIn.createBodega(bodega);
	}

	@Override
	public Bodega updateBodega(Bodega bodega) {
		
		return updateBodegaIn.updateBodega(bodega);
	}

	@Override
	public List<Bodega> selectBodega(Bodega bodega) {
		
		return selectBodegaIn.selectBodega(bodega);
	}

	@Override
	public boolean deleteBodega(Bodega bodega) {
		
		return deleteBodegaIn.deleteBodega(bodega);
	}

}
