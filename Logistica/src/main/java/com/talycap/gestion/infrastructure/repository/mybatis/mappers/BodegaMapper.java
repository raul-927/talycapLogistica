package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.BodegaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.BodegaSqlProvider;


public interface BodegaMapper {
	
	@InsertProvider(type = BodegaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="bodegaId", keyColumn = "bodega_id") 
	void insert(@Param("bodega") BodegaEntity bodega);
	
	@UpdateProvider(type = BodegaSqlProvider.class, method ="update")
	void update(@Param("bodega") BodegaEntity bodega);
	
	@DeleteProvider(type = BodegaSqlProvider.class, method ="delete")
	int delete(@Param("bodega") BodegaEntity bodega);
	
	@SelectProvider(type = BodegaSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.BodegaMapper.BodegaResult")
	List<BodegaEntity> select(@Param("bodega") BodegaEntity bodega);

}
