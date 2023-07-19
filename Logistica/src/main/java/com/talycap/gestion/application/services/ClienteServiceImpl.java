package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.in.cliente.CreateClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.DeleteClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.SelectClienteIn;
import com.talycap.gestion.domain.ports.in.cliente.UpdateClienteIn;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final CreateClienteIn createClienteIn; 
	private final UpdateClienteIn updateClienteIn; 
	private final SelectClienteIn selectClienteIn; 
	private final DeleteClienteIn deleteClienteIn;
	
	
	public ClienteServiceImpl(CreateClienteIn createClienteIn, UpdateClienteIn updateClienteIn,
			SelectClienteIn selectClienteIn, DeleteClienteIn deleteClienteIn) {
		this.createClienteIn = createClienteIn;
		this.updateClienteIn = updateClienteIn;
		this.selectClienteIn = selectClienteIn;
		this.deleteClienteIn = deleteClienteIn;
		
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		
		return createClienteIn.createCliente(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		
		return updateClienteIn.updateCliente(cliente);
	}

	@Override
	public List<Cliente> selectCliente(Cliente cliente) {
		
		return selectClienteIn.selectCliente(cliente);
	}

	@Override
	public boolean deleteCliente(Cliente cliente) {
		
		return deleteClienteIn.deleteCliente(cliente);
	}

}
