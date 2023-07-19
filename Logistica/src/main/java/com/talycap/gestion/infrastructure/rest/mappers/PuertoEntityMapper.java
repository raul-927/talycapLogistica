package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.infrastructure.entitys.PuertoEntity;

@Mapper(componentModel = "spring")
public interface PuertoEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "puertoId", 		target = "puertoId"),
        @Mapping(source = "descripcion", 	target = "descripcion"),
        @Mapping(source = "ubicacion", 		target = "ubicacion")
		})
	Puerto toPuerto(PuertoEntity puertoEntity);

	Iterable<Puerto> toPuertos(Iterable<PuertoEntity> puertosEntity);
	
	@InheritInverseConfiguration
	PuertoEntity toPuertoEnity (Puerto puerto);

}
