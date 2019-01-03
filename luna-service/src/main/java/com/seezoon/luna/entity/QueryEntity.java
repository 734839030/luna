package com.seezoon.luna.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class QueryEntity implements Serializable{
	
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 排序字段，对应db字段名
	 */
	private String sortField;
	/**
	 * 升降序
	 */
	private String direction;

	private Integer page;
	private Integer pageSize;
	
	/**
	 * 自定义查询字段
	 */
	protected Map<String, Object> ext;
	//扩展字段
	private String sfExt1;
	private String sfExt2;
	private String sfExt3;
	private String sfExt4;
	
	/**
	 * 添加自定义参数
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Map<String, Object> addProperty(String key, Object value) {
		if (null == value) {
			return ext;
		}
		if (ext == null) {
			ext = new HashMap<>(1);
		}
		ext.put(key, value);
		return ext;
	}


	public void setSortField(String sortField) {
		this.sortField = sortField;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Map<String, Object> getExt() {
		return ext;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		if (null != pageSize && pageSize > 1000) {
			pageSize = 1000;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String getSortField() {
		return sortField;
	}


	public String getDirection() {
		return direction;
	}


	public String getSfExt1() {
		return sfExt1;
	}


	public void setSfExt1(String sfExt1) {
		this.sfExt1 = sfExt1;
	}


	public String getSfExt2() {
		return sfExt2;
	}


	public void setSfExt2(String sfExt2) {
		this.sfExt2 = sfExt2;
	}


	public String getSfExt3() {
		return sfExt3;
	}


	public void setSfExt3(String sfExt3) {
		this.sfExt3 = sfExt3;
	}


	public String getSfExt4() {
		return sfExt4;
	}


	public void setSfExt4(String sfExt4) {
		this.sfExt4 = sfExt4;
	}


}
