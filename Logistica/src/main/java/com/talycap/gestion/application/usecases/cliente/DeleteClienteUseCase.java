package com.talycap.gestion.application.usecases.cliente;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.in.cliente.DeleteClienteIn;
import com.talycap.gestion.domain.ports.out.ClienteOut;

@Component
public class DeleteClienteUseCase implements DeleteClienteIn {
	
	private final ClienteOut clienteOut;
	
	public DeleteClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public boolean deleteCliente(Cliente cliente) {
		
		return clienteOut.deleteCliente(cliente);
	}

}
