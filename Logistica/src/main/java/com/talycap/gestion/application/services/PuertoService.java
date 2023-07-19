package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.puerto.CreatePuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.DeletePuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.SelectPuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.UpdatePuertoIn;

public interface PuertoService extends CreatePuertoIn, UpdatePuertoIn, SelectPuertoIn, DeletePuertoIn {

}
