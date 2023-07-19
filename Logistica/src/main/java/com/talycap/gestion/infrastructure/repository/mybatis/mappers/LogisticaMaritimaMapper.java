package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.LogisticaMaritimaEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.LogisticaMaritimaSqlProvider;


public interface LogisticaMaritimaMapper {
	
	@InsertProvider(type = LogisticaMaritimaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="logisticaMaritimaId", keyColumn = "logistica_maritima_id") 
	void insert(@Param("logisticaMaritima") LogisticaMaritimaEntity logisticaMaritima);
	
	@UpdateProvider(type = LogisticaMaritimaSqlProvider.class, method ="update")
	void update(@Param("logisticaMaritima") LogisticaMaritimaEntity logisticaMaritima);
	
	@DeleteProvider(type = LogisticaMaritimaSqlProvider.class, method ="delete")
	int delete(@Param("logisticaMaritima") LogisticaMaritimaEntity logisticaMaritima);
	
	@SelectProvider(type = LogisticaMaritimaSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaMaritimaMapper.LogisticaMaritimaResult")
	List<LogisticaMaritimaEntity> select(@Param("logisticaMaritima") LogisticaMaritimaEntity logisticaMaritima);

}
