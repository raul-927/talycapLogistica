package com.talycap.gestion.domain.ports.in.tipoproducto;

import java.util.List;

import com.talycap.gestion.domain.models.TipoProducto;

public interface SelectTipoProductoIn {
	
	List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto);

}
