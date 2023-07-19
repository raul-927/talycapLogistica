package com.talycap.gestion.domain.ports.in.tipoproducto;

import com.talycap.gestion.domain.models.TipoProducto;

public interface DeleteTipoProductoIn {
	boolean deleteTipoProducto(TipoProducto tipoProducto);

}
