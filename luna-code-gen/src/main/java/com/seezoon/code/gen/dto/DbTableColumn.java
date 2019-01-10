package com.seezoon.code.gen.dto;

public class DbTableColumn {

	/**
	 * DB 列名称
	 */
	private String name;
	/**
	 * 是否可空1: 可;0:不可以
	 */
	private String nullable;
	private Integer sort;
	/**
	 * 列备注
	 */
	private String comment;
	/**
	 * 数据类型eg:varchar
	 */
	private String dataType;
	private Long maxlength;
	/**
	 * 列类型 eg:varchar(64)
	 */
	private String columnType;
	/**
	 * 主键类型 如PRI
	 */
	private String columnKey;
	/**
	 * 主键额外说明 如auto_increment
	 */
	private String extra;

	/**非DB字段，下列用于代码生成**/
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
	/**
	 * 是否可插入1: 可;0:不可以
	 */
	private String insert;
	/**
	 * 是否可更新1: 可;0:不可以
	 */
	private String update;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(Long maxlength) {
		this.maxlength = maxlength;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
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

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

}
