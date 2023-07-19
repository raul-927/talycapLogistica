package com.talycap.gestion.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.infrastructure.entitys.TipoProductoEntity;




@Mapper(componentModel = "spring")
public interface TipoProductoEntityMapper {
	
	
	@Mappings({
		@Mapping(source = "tipoProductoId", 		target = "tipoProductoId"),
        @Mapping(source = "nombreTipoProducto", 	target = "nombreTipoProducto")
		})
	TipoProducto toTipoProducto(TipoProductoEntity tipoProductoEntity);

	Iterable<TipoProducto> toTipoProductos(Iterable<TipoProductoEntity> tiposProductosEntity);
	
	@InheritInverseConfiguration
	TipoProductoEntity toTipoProductoEntity (TipoProducto tipoProducto);

}
