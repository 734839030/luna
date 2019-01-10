package com.seezoon.code.gen.dto;

public class DbPk {

	private String dataType;
	private String columnName;
	
	/**
	 * 对应的java类型
	 */
	private String javaType;
	/**
	 * 对应的mysbtis JDBC类型
	 */
	private String jdbcType;
	/**
	 * 字段名称
	 */
	private String javaFieldName;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}
	public String getJavaFieldName() {
		return javaFieldName;
	}
	public void setJavaFieldName(String javaFieldName) {
		this.javaFieldName = javaFieldName;
	}
	
}
