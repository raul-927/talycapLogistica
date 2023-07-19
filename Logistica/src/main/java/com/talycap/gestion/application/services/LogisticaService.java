package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.logistica.CreateLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.DeleteLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.SelectLogisticaIn;
import com.talycap.gestion.domain.ports.in.logistica.UpdateLogisticaIn;

public interface LogisticaService extends CreateLogisticaIn, UpdateLogisticaIn, SelectLogisticaIn, DeleteLogisticaIn {

}
