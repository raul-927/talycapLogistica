package com.talycap.gestion.application.usecases.cliente;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.in.cliente.CreateClienteIn;
import com.talycap.gestion.domain.ports.out.ClienteOut;

@Component
public class CreateClienteUseCase implements CreateClienteIn {
	
	private final ClienteOut clienteOut;
	
	
	public CreateClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		
		return clienteOut.createCliente(cliente);
	}

}
