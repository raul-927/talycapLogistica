package com.talycap.gestion.domain.ports.in.bodega;

import com.talycap.gestion.domain.models.Bodega;

public interface DeleteBodegaIn {
	boolean deleteBodega(Bodega bodega);
}
