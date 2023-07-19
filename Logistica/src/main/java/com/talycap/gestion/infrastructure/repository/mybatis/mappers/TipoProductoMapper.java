package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.TipoProductoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.TipoProductoSqlProvider;


public interface TipoProductoMapper {
	
	@InsertProvider(type = TipoProductoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="tipoProductoId", keyColumn = "tipo_producto_id") 
	void insert(@Param("tipoProducto") TipoProductoEntity tipoProducto);
	
	@UpdateProvider(type = TipoProductoSqlProvider.class, method ="update")
	void update(@Param("tipoProducto") TipoProductoEntity tipoProducto);
	
	@DeleteProvider(type = TipoProductoSqlProvider.class, method ="delete")
	int delete(@Param("tipoProducto") TipoProductoEntity tipoProducto);
	
	@SelectProvider(type = TipoProductoSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.TipoProductoMapper.TipoProductoResult")
	List<TipoProductoEntity> select(@Param("tipoProducto") TipoProductoEntity tipoProducto);

}
