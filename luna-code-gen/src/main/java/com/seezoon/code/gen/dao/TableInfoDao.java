package com.seezoon.code.gen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seezoon.code.gen.dto.DbPk;
import com.seezoon.code.gen.dto.DbTable;
import com.seezoon.code.gen.dto.DbTableColumn;

@Mapper
public interface TableInfoDao {

	public DbTable findTable(String tableName);
	public List<DbTableColumn> findColumnByTableName(String tableName);
	public List<DbPk> findPkType(String tableName);

}
