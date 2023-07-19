package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.tipoproducto.CreateTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.DeleteTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.SelectTipoProductoIn;
import com.talycap.gestion.domain.ports.in.tipoproducto.UpdateTipoProductoIn;

public interface TipoProductoService
		extends CreateTipoProductoIn, UpdateTipoProductoIn, SelectTipoProductoIn, DeleteTipoProductoIn {

}
