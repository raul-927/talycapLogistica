package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.infrastructure.entitys.ClienteEntity;


@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "clienteId", target = "clienteId"),
        @Mapping(source = "nombre", 	target = "nombre"),
        @Mapping(source = "apellido", 	target = "apellido"),
        @Mapping(source = "documento", 	target = "documento")
		})
	Cliente toCliente(ClienteEntity clienteEntity);

	Iterable<Cliente> toClientes(Iterable<ClienteEntity> clientesEntity);
	
	@InheritInverseConfiguration
	ClienteEntity toClienteEnity (Cliente cliente);

}
