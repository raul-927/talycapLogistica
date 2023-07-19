package com.talycap.gestion.domain.ports.out;

import java.util.List;

import com.talycap.gestion.domain.models.Cliente;

public interface ClienteOut {
	Cliente createCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente);
	List<Cliente> selectCliente(Cliente cliente);
	boolean deleteCliente(Cliente cliente);

}
