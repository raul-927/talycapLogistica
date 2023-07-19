package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Bodega;

public interface BodegaOut {
	Bodega createBodega(Bodega bodega);
	Bodega updateBodega(Bodega bodega);
	List<Bodega> selectBodega(Bodega bodega);
	boolean deleteBodega(Bodega bodega);

}
