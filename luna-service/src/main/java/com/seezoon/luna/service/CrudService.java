package com.seezoon.luna.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seezoon.luna.dao.CrudDao;
import com.seezoon.luna.entity.BaseEntity;


/**
 * 增删改查
 * 
 * @author hdf 2018年3月31日
 * @param <D>
 * @param <T>
 */
public class CrudService<D extends CrudDao<T>, T extends BaseEntity> extends BaseTransactionService {

	@Autowired
	protected D d;
	
	public int save(T t) {
		t.setCreateDate(new Date());
		t.setUpdateDate(t.getCreateDate());
		this.fillExts(t);
		if (StringUtils.isEmpty(t.getCreateBy())) {
			t.setCreateBy(this.getUserId());
		}
		t.setUpdateBy(t.getCreateBy());
		//自增主键的insert sql 不能出现插入id 
		if (null == t.getId() || StringUtils.isEmpty(t.getId().toString())) {
			Class<?> clazz = t.getClass();  
		    Type type = clazz.getGenericSuperclass();  
		    ParameterizedType parameterizedType = (ParameterizedType) type;  
		    if (parameterizedType.getActualTypeArguments()[0].equals(String.class)) {
		    		//t.setId(IdGen.uuid()); 这个要是编译可以过去就不用这么麻烦去获取主键类型
		    		Field findField = ReflectionUtils.findField(clazz, "id");
		    		try {
		    			    findField.setAccessible(true);
						findField.set(t, UUID.randomUUID().toString().replace("-", ""));
				} catch (Exception e) {
					logger.error("set id error:",e);
				} 
		   }
		}
		int cnt = d.insert(t);
		return cnt;
	}
	public int updateSelective(T t) {
		Assert.notNull(t, "更新对象为空");
		Assert.notNull(t.getId(), "更新对象id为空");
		t.setUpdateDate(new Date());
		if (StringUtils.isEmpty(t.getUpdateBy())) {
			t.setUpdateBy(this.getUserId());
		}
		int cnt = d.updateByPrimaryKeySelective(t);
		return cnt;
	}

	public int updateById(T t) {
		Assert.notNull(t, "更新对象为空");
		Assert.notNull(t.getId(), "更新对象id为空");
		t.setUpdateDate(new Date());
		fillExts(t);
		if (StringUtils.isEmpty(t.getUpdateBy())) {
			t.setUpdateBy(this.getUserId());
		}
		int cnt = d.updateByPrimaryKey(t);
		return cnt;
	}

	@Transactional(readOnly = true)
	public T findById(Object id) {
		Assert.notNull(id, "id为空");
		return d.selectByPrimaryKey(id);
	}

	/**
	 * 慎用删除
	 * @param id
	 * @return
	 */
	public int deleteById(Object id) {
		Assert.notNull(id, "id为空");
		return d.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	public List<T> findList(T t) {
		fillExts(t);
		return d.findList(t);
	}

	/**
	 * 
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @param count
	 *            是否统计总数
	 * @return
	 */
	@Transactional(readOnly = true)
	public PageInfo<T> findByPage(T t, int pageNum, int pageSize, boolean count) {
		PageHelper.startPage(pageNum, pageSize, count);
		List<T> list = this.findList(t);
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	@Transactional(readOnly = true)
	public PageInfo<T> findByPage(T t, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, Boolean.TRUE);
		List<T> list = this.findList(t);
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}
	private String getUserId() {
		OperatorUser operatorUser = OperatorUser.get();
		return null != operatorUser?operatorUser.getUserId():null;
	}
	private void fillExts(T t) {
		OperatorUser operatorUser = OperatorUser.get();
		if (null != operatorUser && t != null) {
			t.setSfExt1(operatorUser.getExt1());
			t.setSfExt2(operatorUser.getExt2());
			t.setSfExt3(operatorUser.getExt3());
			t.setSfExt4(operatorUser.getExt4());
		}
	}

}
