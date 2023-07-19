package com.talycap.gestion.application.services;

import com.talycap.gestion.domain.ports.in.cliente.CreateClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.DeleteClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.SelectClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.UpdateClienteIn;

public interface ClienteService extends CreateClienteIn, UpdateClienteIn, SelectClienteIn, DeleteClienteIn {

}
