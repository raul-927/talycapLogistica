package com.talycap.gestion.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.domain.ports.out.ClienteOut;
import com.talycap.gestion.infrastructure.entitys.ClienteEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.ClienteMapper;
import com.talycap.gestion.infrastructure.rest.mappers.ClienteEntityMapper;

@Component
public class ClienteAdapter implements ClienteOut {
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public Cliente createCliente(Cliente cliente) {
		ClienteEntity cEntity = clienteEntityMapper.toClienteEnity(cliente);
		clienteMapper.insert(cEntity);
		
		return clienteEntityMapper.toCliente(cEntity);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		ClienteEntity cEntity = clienteEntityMapper.toClienteEnity(cliente);
		clienteMapper.update(cEntity);
		
		return clienteEntityMapper.toCliente(cEntity);
	}

	@Override
	public List<Cliente> selectCliente(Cliente cliente) {
		List<ClienteEntity> clienteEntityList = clienteMapper.select(clienteEntityMapper.toClienteEnity(cliente));
		List<Cliente> clienteResult = (List<Cliente>) clienteEntityMapper.toClientes(clienteEntityList);
		return clienteResult;
	}

	@Override
	public boolean deleteCliente(Cliente cliente) {
		List<ClienteEntity> clienteEntityList = clienteMapper.select(clienteEntityMapper.toClienteEnity(cliente));
		if(!clienteEntityList.isEmpty()) {
			clienteMapper.delete(clienteEntityList.get(0));
			return true;
		}
		return false;
	}

}
