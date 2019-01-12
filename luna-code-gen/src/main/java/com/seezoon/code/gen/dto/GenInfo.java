package com.seezoon.code.gen.dto;

import java.util.List;

public class GenInfo {

	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * DB 备注
	 */
	private String tableComment;
	/**
	 * 主键类型
	 */
	private String pkJavaType;
	/**
	 * 单一主键
	 */
	private boolean singlePk;
	/**
	 * 是否自增主键
	 */
	private boolean autoIncrement;
	/**
	 * 模块名
	 */
	private String moduleName;
	/**
	 * 功能模块
	 */
	private String functionName;
	
	/**
	 * 类名
	 */
	private String className;
	/**
	 *  列
	 */
	private List<DbTableColumn> columns;
	/**
	 * 主键
	 */
	private List<DbPk> pks;
	/**
	 * 是否引入Date
	 */
	private boolean hasDate;
	/**
	 * 是否引入BigDecimal
	 */
	private boolean hasBigDecimal;
	private boolean hasBlob;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<DbTableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<DbTableColumn> columns) {
		this.columns = columns;
	}
	public boolean isHasDate() {
		return hasDate;
	}
	public void setHasDate(boolean hasDate) {
		this.hasDate = hasDate;
	}
	public boolean isHasBigDecimal() {
		return hasBigDecimal;
	}
	public void setHasBigDecimal(boolean hasBigDecimal) {
		this.hasBigDecimal = hasBigDecimal;
	}
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	public List<DbPk> getPks() {
		return pks;
	}
	public void setPks(List<DbPk> pks) {
		this.pks = pks;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public boolean isHasBlob() {
		return hasBlob;
	}
	public void setHasBlob(boolean hasBlob) {
		this.hasBlob = hasBlob;
	}
	public String getPkJavaType() {
		return pkJavaType;
	}
	public void setPkJavaType(String pkJavaType) {
		this.pkJavaType = pkJavaType;
	}
	public boolean isSinglePk() {
		return singlePk;
	}
	public void setSinglePk(boolean singlePk) {
		this.singlePk = singlePk;
	}
	
}
