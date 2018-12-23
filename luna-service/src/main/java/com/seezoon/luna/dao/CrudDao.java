package com.seezoon.luna.dao;

import java.util.List;

import com.seezoon.luna.entity.BaseEntity;

/**
 * 当需要自动拥有增删改查功能时候继承
 * 
 * 不推荐联合主键,支持字符和整数主键
 * 
 * @author hdf 2017年8月30日
 * @param <M>
 *            mapper
 * @param <T>
 *            entity
 */
public interface CrudDao<T extends BaseEntity> extends BaseDao {

	public int insert(T t);
	
	public int updateByPrimaryKeySelective(T t);

	public int updateByPrimaryKey(T t);

	public T selectByPrimaryKey(Object id);

	public int deleteByPrimaryKey(Object id);

	public List<T> findList(T t);
}
