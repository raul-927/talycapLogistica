package com.talycap.gestion.infrastructure.repository.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.talycap.gestion.infrastructure.entitys.ClienteEntity;
import com.talycap.gestion.infrastructure.repository.mybatis.sql.ClienteSqlProvider;


public interface ClienteMapper {
	
	@InsertProvider(type = ClienteSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="clienteId", keyColumn = "cliente_id") 
	void insert(@Param("cliente") ClienteEntity cliente);
	
	@UpdateProvider(type = ClienteSqlProvider.class, method ="update")
	void update(@Param("cliente") ClienteEntity cliente);
	
	@DeleteProvider(type = ClienteSqlProvider.class, method ="delete")
	int delete(@Param("cliente") ClienteEntity cliente);
	
	@SelectProvider(type = ClienteSqlProvider.class, method ="select")
	@ResultMap("com.talycap.gestion.infrastructure.repository.mybatis.mappers.ClienteMapper.ClienteResult")
	List<ClienteEntity> select(@Param("cliente") ClienteEntity cliente);

}
