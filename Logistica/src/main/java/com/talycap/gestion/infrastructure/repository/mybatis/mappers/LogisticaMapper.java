package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.LogisticaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.LogisticaSqlProvider;


public interface LogisticaMapper {
	
	@InsertProvider(type = LogisticaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="logisticaId", keyColumn = "logistica_id") 
	void insert(@Param("logistica") LogisticaEntity logistica);
	
	@UpdateProvider(type = LogisticaSqlProvider.class, method ="update")
	void update(@Param("logistica") LogisticaEntity logistica);
	
	@DeleteProvider(type = LogisticaSqlProvider.class, method ="delete")
	int delete(@Param("logistica") LogisticaEntity logistica);
	
	@SelectProvider(type = LogisticaSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaMapper.LogisticaResult")
	List<LogisticaEntity> select(@Param("logistica") LogisticaEntity logistica);

}
