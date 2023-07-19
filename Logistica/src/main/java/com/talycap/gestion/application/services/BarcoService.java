package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.barco.CreateBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.DeleteBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.SelectBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.UpdateBarcoIn;

public interface BarcoService extends CreateBarcoIn, UpdateBarcoIn, SelectBarcoIn, DeleteBarcoIn{

}
