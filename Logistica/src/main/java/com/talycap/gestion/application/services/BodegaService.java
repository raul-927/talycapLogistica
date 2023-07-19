package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.bodega.CreateBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.DeleteBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.SelectBodegaIn;
import com.talycap.gestion.domain.ports.in.bodega.UpdateBodegaIn;

public interface BodegaService extends CreateBodegaIn, UpdateBodegaIn, SelectBodegaIn, DeleteBodegaIn{

}
