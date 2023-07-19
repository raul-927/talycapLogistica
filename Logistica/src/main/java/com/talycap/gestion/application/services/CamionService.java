package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.camion.CreateCamionIn;
import com.talycap.gestion.domain.ports.in.camion.DeleteCamionIn;
import com.talycap.gestion.domain.ports.in.camion.SelectCamionIn;
import com.talycap.gestion.domain.ports.in.camion.UpdateCamionIn;

public interface CamionService extends CreateCamionIn, UpdateCamionIn, SelectCamionIn, DeleteCamionIn{

}
