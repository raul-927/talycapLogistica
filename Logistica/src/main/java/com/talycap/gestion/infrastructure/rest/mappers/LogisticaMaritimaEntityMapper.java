package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.infrastructure.entitys.LogisticaMaritimaEntity;

@Mapper(componentModel = "spring")
public interface LogisticaMaritimaEntityMapper {
	
	@Mappings({
		@Mapping(source = "logisticaMaritimaId", target = "logisticaMaritimaId"),
        @Mapping(source = "barco", 	target = "barco"),
        @Mapping(source = "puerto", target = "puerto")
		})
	LogisticaMaritima toLogisticaMaritima(LogisticaMaritimaEntity logisticaMaritimaEntity);

	Iterable<LogisticaMaritima> toLogisticasMaritimas(Iterable<LogisticaMaritimaEntity> logisticasMaritimasEntity);
	
	@InheritInverseConfiguration
	LogisticaMaritimaEntity toLogisticaMaritimaEntity (LogisticaMaritima logisticaMaritima);

}
