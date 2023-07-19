package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.infrastructure.entitys.BodegaEntity;


@Mapper(componentModel = "spring")
public interface BodegaEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "bodegaId", 		target = "bodegaId"),
        @Mapping(source = "nombreBodega", 	target = "nombreBodega")
		})
	Bodega toBodega(BodegaEntity bodegaEntity);

	Iterable<Bodega> toBodegas(Iterable<BodegaEntity> bodegasEntity);
	
	@InheritInverseConfiguration
	BodegaEntity toBodegaEnity (Bodega bodega);

}
