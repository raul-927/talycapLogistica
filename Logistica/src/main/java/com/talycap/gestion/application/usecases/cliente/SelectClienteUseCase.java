package com.talycap.gestion.application.usecases.cliente;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.in.cliente.SelectClienteIn;
import com.talycap.gestion.domain.ports.out.ClienteOut;

@Component
public class SelectClienteUseCase implements SelectClienteIn {
	
	private final ClienteOut clienteOut;
	
	
	public SelectClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public List<Cliente> selectCliente(Cliente cliente) {
		
		return clienteOut.selectCliente(cliente);
	}

}
