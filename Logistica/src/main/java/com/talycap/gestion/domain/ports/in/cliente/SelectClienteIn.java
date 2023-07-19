package com.talycap.gestion.domain.ports.in.cliente;

import java.util.List;

import com.talycap.gestion.domain.models.Cliente;

public interface SelectClienteIn {
	
	List<Cliente> selectCliente(Cliente cliente);
}
