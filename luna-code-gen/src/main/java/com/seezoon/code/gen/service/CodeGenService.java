package com.seezoon.code.gen.service;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.seezoon.code.gen.dao.TableInfoDao;
import com.seezoon.code.gen.dto.DbPk;
import com.seezoon.code.gen.dto.DbTable;
import com.seezoon.code.gen.dto.DbTableColumn;
import com.seezoon.code.gen.dto.GenInfo;
import com.seezoon.code.gen.utils.Constants;
import com.seezoon.code.gen.utils.GenTypeMapping;

@Service
public class CodeGenService {

	@Autowired
	private TableInfoDao tableInfoDao;
	
	/**
	 * 默认不更新
	 */
	private static final String[] defaultNotUpdates = { "create_by", "create_date" };
	/**
	 * 默认有的字段
	 */
	private static final String[] defaultFields = { "id", "create_by", "create_date", "update_by", "update_date",
			"remarks" };
	
	public void gen(String tableName) {
		Assert.hasLength(tableName,"tableName is empty");
		List<DbTableColumn> columns = tableInfoDao.findColumnByTableName(tableName);
		Assert.notEmpty(columns, "columns is empty");
	}
	/**
	 * 根据db表的元信息获取生成数据信息
	 * @param tableName
	 * @return
	 */
	private GenInfo getGenInfo(String tableName) {
		Assert.hasLength(tableName,"tableName is empty");
		List<DbTableColumn> columns = tableInfoDao.findColumnByTableName(tableName);
		Assert.notEmpty(columns, "columns is empty");
		GenInfo genInfo = new GenInfo();
		genInfo.setTableName(tableName);
		DbTable dbTable = tableInfoDao.findTable(tableName);
		genInfo.setTableComment(dbTable.getComment());
		// 模块名默认下滑线分隔第一组
		String[] split = tableName.split("_");
		genInfo.setModuleName(split[0]);
		if (split.length > 1) {
			StringBuilder sb = new StringBuilder();
			genInfo.setFunctionName(split[1]);
			for (int i=1;i<split.length;i++) {
				sb.append(split[i]);
			}
			genInfo.setFunctionName(sb.toString());
		}
		genInfo.setClassName(camelToUnderline(tableName));
		List<DbPk> pkTypes = tableInfoDao.findPkType(tableName);
		Assert.notEmpty(pkTypes, tableName + " 无主键");
		genInfo.setPks(pkTypes);
		for (DbTableColumn dbTableColumn : columns) {
			dbTableColumn.setJavaType(GenTypeMapping.getDbJavaMapping(dbTableColumn.getDataType()));
			dbTableColumn.setJdbcType(GenTypeMapping.getDbMybatisMapping(dbTableColumn.getDataType()));
			dbTableColumn.setJavaFieldName(columnToJava(dbTableColumn.getName()));
			//自增默认不插入
			if (!"auto_increment".equals(dbTableColumn.getExtra())) {
				dbTableColumn.setInsert(Constants.YES);
			} else {
				genInfo.setAutoIncrement(true);
			}
			//默认不更新字段和主键不更新
			if (!ArrayUtils.contains(defaultNotUpdates, dbTableColumn.getName()) && !"PRI".equals(dbTableColumn.getColumnKey())) {
				dbTableColumn.setUpdate(Constants.YES);
			}
			if (!ArrayUtils.contains(defaultFields, dbTableColumn.getName())) {
				String javaType = dbTableColumn.getJavaType();
				if ("BigDecimal".equals(javaType)) {
					genInfo.setHasBigDecimal(true);
				}
				if ("Date".equals(javaType)) {
					genInfo.setHasDate(true);
				}
			}
		}
		genInfo.setColumns(columns);
		return genInfo;
	}
	/**
	 * 列名转换成Java属性名
	 */
	public static String columnToJava(String columnName) {
		return StringUtils.uncapitalize(camelToUnderline(columnName));
	}
	/**
	 * 驼峰
	 */
	public static String camelToUnderline(String name) {
		return WordUtils.capitalizeFully(name, new char[] { '_' }).replace("_", "");
	}
}
