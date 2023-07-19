package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.infrastructure.entitys.BarcoEntity;



@Mapper(componentModel = "spring")
public interface BarcoEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "barcoId", 		target = "barcoId"),
        @Mapping(source = "nroFlota", 		target = "nroFlota"),
        @Mapping(source = "nombreBarco", 	target = "nombreBarco")
		})
	Barco toBarco(BarcoEntity barcoEntity);

	Iterable<Barco> toBarcos(Iterable<BarcoEntity> barcoEntity);
	
	@InheritInverseConfiguration
	BarcoEntity toBarcoEnity (Barco barco);

}
