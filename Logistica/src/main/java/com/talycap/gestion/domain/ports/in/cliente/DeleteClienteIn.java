package com.talycap.gestion.domain.ports.in.cliente;

import com.talycap.gestion.domain.models.Cliente;

public interface DeleteClienteIn {
	
	boolean deleteCliente(Cliente cliente);

}
