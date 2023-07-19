package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.CamionEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.CamionSqlProvider;


public interface CamionMapper {
	
	@InsertProvider(type = CamionSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="camionId", keyColumn = "camion_id") 
	void insert(@Param("camion") CamionEntity camion);
	
	@UpdateProvider(type = CamionSqlProvider.class, method ="update")
	void update(@Param("camion") CamionEntity camion);
	
	@DeleteProvider(type = CamionSqlProvider.class, method ="delete")
	int delete(@Param("camion") CamionEntity camion);
	
	@SelectProvider(type = CamionSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.CamionMapper.CamionResult")
	List<CamionEntity> select(@Param("camion") CamionEntity camion);

}
