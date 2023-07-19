package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.PuertoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.PuertoSqlProvider;


public interface PuertoMapper {
	
	@InsertProvider(type = PuertoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="puertoId", keyColumn = "puerto_id") 
	void insert(@Param("puerto") PuertoEntity puerto);
	
	@UpdateProvider(type = PuertoSqlProvider.class, method ="update")
	void update(@Param("puerto") PuertoEntity puerto);
	
	@DeleteProvider(type = PuertoSqlProvider.class, method ="delete")
	int delete(@Param("puerto") PuertoEntity puerto);
	
	@SelectProvider(type = PuertoSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.PuertoMapper.PuertoResult")
	List<PuertoEntity> select(@Param("puerto") PuertoEntity puerto);

}
