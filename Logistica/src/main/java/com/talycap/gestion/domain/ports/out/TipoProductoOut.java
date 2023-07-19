package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.TipoProducto;

public interface TipoProductoOut {
	TipoProducto createTipoProducto(TipoProducto tipoProducto);
	TipoProducto updateTipoProducto(TipoProducto tipoProducto);
	List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto);
	boolean deleteTipoProducto(TipoProducto tipoProducto);

}
