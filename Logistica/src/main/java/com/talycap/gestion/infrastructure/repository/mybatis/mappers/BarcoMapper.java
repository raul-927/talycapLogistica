package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.BarcoEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.BarcoSqlProvider;


public interface BarcoMapper {
	
	@InsertProvider(type = BarcoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="barcoId", keyColumn = "barco_id") 
	void insert(@Param("barco") BarcoEntity barco);
	
	@UpdateProvider(type = BarcoSqlProvider.class, method ="update")
	void update(@Param("barco") BarcoEntity barco);
	
	@DeleteProvider(type = BarcoSqlProvider.class, method ="delete")
	int delete(@Param("barco") BarcoEntity barco);
	
	@SelectProvider(type = BarcoSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.BarcoMapper.BarcoResult")
	List<BarcoEntity> select(@Param("barco") BarcoEntity barco);

}
