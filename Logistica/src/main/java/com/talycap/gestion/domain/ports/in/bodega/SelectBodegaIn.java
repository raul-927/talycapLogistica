package com.talycap.gestion.domain.ports.in.bodega;

import java.util.List;

import com.talycap.gestion.domain.models.Bodega;

public interface SelectBodegaIn {
	List<Bodega> selectBodega(Bodega bodega);
}
