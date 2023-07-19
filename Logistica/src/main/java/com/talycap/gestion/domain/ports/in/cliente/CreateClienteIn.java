package com.talycap.gestion.domain.ports.in.cliente;

import com.talycap.gestion.domain.models.Cliente;

public interface CreateClienteIn {
	Cliente createCliente(Cliente cliente);

}
