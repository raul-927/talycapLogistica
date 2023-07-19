package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.LogisticaTerrestreEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.LogisticaTerrestreSqlProvider;


public interface LogisticaTerrestreMapper {
	
	@InsertProvider(type = LogisticaTerrestreSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="logisticaTerrestreId", keyColumn = "logistica_terrestre_id") 
	void insert(@Param("logisticaTerrestre") LogisticaTerrestreEntity logisticaTerrestre);
	
	@UpdateProvider(type = LogisticaTerrestreSqlProvider.class, method ="update")
	void update(@Param("logisticaTerrestre") LogisticaTerrestreEntity logisticaTerrestre);
	
	@DeleteProvider(type = LogisticaTerrestreSqlProvider.class, method ="delete")
	int delete(@Param("logisticaTerrestre") LogisticaTerrestreEntity logisticaTerrestre);
	
	@SelectProvider(type = LogisticaTerrestreSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaTerrestreMapper.LogisticaTerrestreResult")
	List<LogisticaTerrestreEntity> select(@Param("logisticaTerrestre") LogisticaTerrestreEntity logisticaTerrestre);

}
