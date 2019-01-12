package com.seezoon.code.gen.dao;

import java.util.List;

import com.seezoon.code.gen.dto.DbPk;
import com.seezoon.code.gen.dto.DbTable;
import com.seezoon.code.gen.dto.DbTableColumn;
import com.seezoon.luna.dao.BaseDao;

public interface TableInfoDao extends BaseDao {

	public DbTable findTable(String tableName);
	public List<DbTableColumn> findColumnByTableName(String tableName);
	public List<DbPk> findPkType(String tableName);

}
