package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.infrastructure.entitys.CamionEntity;

@Mapper(componentModel = "spring")
public interface CamionEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "camionId", 	target = "camionId"),
        @Mapping(source = "placa", 		target = "placa"),
        @Mapping(source = "modelo", 	target = "modelo"),
        @Mapping(source = "marca", 		target = "marca")
		
		
		
		})
	Camion toCamion(CamionEntity camionEntity);

	Iterable<Camion> toCamiones(Iterable<CamionEntity> camionesEntity);
	
	@InheritInverseConfiguration
	CamionEntity toCamionEnity (Camion camion);

}
