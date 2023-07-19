package com.talycap.gestion.application.usecases.cliente;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.in.cliente.UpdateClienteIn;
import com.talycap.gestion.domain.ports.out.ClienteOut;

@Component
public class UpdateClienteUseCase implements UpdateClienteIn {
	
	private final ClienteOut clienteOut;
	
	public UpdateClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		
		return clienteOut.updateCliente(cliente);
	}

}
