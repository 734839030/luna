package com.seezoon.code.gen.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
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
import com.seezoon.code.gen.utils.FreeMarkerUtils;
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
	/**
	 * 待生成模板
	 */
	public static final String[] ftls = {"mapper.xml.ftl","entity.java.ftl","dao.java.ftl","service.java.ftl"};
	private static final String javaServiceFolder = "/seezoon-code/src/main/java/com/seezoon/service/modules/";
	private static final String resourcesFolder = "/seezoon-code/src/main/resources/";

	public void gen(String tableName) throws Exception {
		Assert.hasLength(tableName,"tableName is empty");
		GenInfo genInfo = this.getGenInfo(tableName);
		byte[] codeGen = this.zipCode(genInfo);
		FileOutputStream output = new FileOutputStream("/Users/hdf/Downloads/代码生成.zip");
		IOUtils.write(codeGen, output);
		output.flush();
		output.close();
	}
	private byte[] zipCode(GenInfo genInfo) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(bos);
		for (String ftl : ftls) {
			String content = FreeMarkerUtils.renderTemplate(ftl, genInfo);
			zos.putNextEntry(new ZipEntry(this.getZipEntryName(ftl,genInfo)));
			IOUtils.write(content, zos,Charset.forName("UTF-8"));
			zos.closeEntry();
		}
		zos.close();
		byte[] byteArray = bos.toByteArray();
		return byteArray;
	}
	public String getZipEntryName(String ftl,GenInfo genInfo) {
		String name = null;
		String moduleName = genInfo.getModuleName();
		String className = genInfo.getClassName();
		if (ftl.contains("entity.java")) {
			name = javaServiceFolder + moduleName + "/entity/" + className + ".java";
		} else if (ftl.contains("dao.java")) {
			name = javaServiceFolder + moduleName + "/dao/" + className + "Dao.java";
		} else if (ftl.contains("service.java")) {
			name = javaServiceFolder + moduleName + "/service/" + className + "Service.java";
		}  else if (ftl.contains("mapper.xml")) {
			name = resourcesFolder + "mappings/" + moduleName + "/" + className + "Mapper.xml";
		} 
		Assert.hasLength(name, "zipEntryName 为空");
		return name;
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
			for (DbPk pk:pkTypes) {
				if (pk.getColumnName().equals(dbTableColumn.getName())) {
					pk.setJavaType(dbTableColumn.getJavaType());
					pk.setJdbcType(dbTableColumn.getJdbcType());
					pk.setJavaFieldName(dbTableColumn.getJavaFieldName());
				}
			}
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
			//大字段
			if ("LONGVARCHAR".equals(dbTableColumn.getJdbcType())) {
				genInfo.setHasBlob(true);
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
		if (pkTypes.size() == 1) {
			genInfo.setPkJavaType(pkTypes.get(0).getJavaType());
		} else {
			genInfo.setPkJavaType("com.seezoon.service.modules." + genInfo.getModuleName() +".entity." + genInfo.getClassName());
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
