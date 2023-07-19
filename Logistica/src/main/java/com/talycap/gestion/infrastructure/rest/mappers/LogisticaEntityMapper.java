package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.infrastructure.entitys.LogisticaEntity;


@Mapper(componentModel = "spring")
public interface LogisticaEntityMapper {
	
	@Mappings({
		@Mapping(source = "logisticaId", 		target = "logisticaId"),
        @Mapping(source = "tipoProducto", 		target = "tipoProducto"),
        @Mapping(source = "precioEnvio", 		target = "precioEnvio"),
        @Mapping(source = "cantidadProducto", 	target = "cantidadProducto"),
        @Mapping(source = "subTotal", 			target = "subTotal"),
        @Mapping(source = "porcentajeDescuento",target = "porcentajeDescuento"),
        @Mapping(source = "total", 				target = "total"),
        @Mapping(source = "fechaRegistro", 		target = "fechaRegistro"),
        @Mapping(source = "fechaEntrega", 		target = "fechaEntrega"),
        @Mapping(source = "cliente", 			target = "cliente"),
        @Mapping(source = "logisticaTerrestre", target = "logisticaTerrestre"),
        @Mapping(source = "logisticaMaritima", 	target = "logisticaMaritima")
		})
	Logistica toLogistica(LogisticaEntity logisticaEntity);

	Iterable<Logistica> toLogisticas(Iterable<LogisticaEntity> logisticasEntity);
	
	@InheritInverseConfiguration
	LogisticaEntity toLogisticaEntity (Logistica logistica);

}
