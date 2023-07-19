package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.infrastructure.entitys.LogisticaTerrestreEntity;

@Mapper(componentModel = "spring")
public interface LogisticaTerrestreEntityMapper {
	
	@Mappings({
		@Mapping(source = "logisticaTerrestreId", target = "logisticaTerrestreId"),
        @Mapping(source = "camion", target = "camion"),
        @Mapping(source = "bodega", target = "bodega")
		})
	LogisticaTerrestre toLogisticaTerrestre(LogisticaTerrestreEntity logisticaTerrestreEntity);

	Iterable<LogisticaTerrestre> toLogisticasTerrestres(Iterable<LogisticaTerrestreEntity> logisticasTerrestresEntity);
	
	@InheritInverseConfiguration
	LogisticaTerrestreEntity toLogisticaTerrestreEntity (LogisticaTerrestre logisticaTerrestre);

}
