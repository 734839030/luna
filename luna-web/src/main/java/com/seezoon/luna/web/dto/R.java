package com.seezoon.luna.web.dto;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.seezoon.luna.web.exception.ErrorCodes;
import com.seezoon.luna.web.exception.ErrorType;

/**
 * 前端返回数据结构
 * @author hdf
 *
 */
public class R {

	/**
	 * 线程号
	 */
	private String tid;
	/**
	 * 响应吗
	 */
	private String code;
	/**
	 * 响应消息
	 */
	private String msg;
	/**
	 * 实际数据
	 */
	private Object data;
	
	private R(ErrorType errorType) {
		this.code = errorType.code();
		this.msg = errorType.msg();
	}
	private R(String code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static R ok() {
		R r = new R(ErrorCodes.SUCCESS);
		return r;
	}
	public static R ok(Object data) {
		R r = new R(ErrorCodes.SUCCESS);
		r.setData(data);
		return r;
	}
	public static R error(String msg) {
		R r = new R(ErrorCodes.FAIL);
		r.setMsg(msg);
		return r;
	}
	public static R error(ErrorType errorType) {
		R r = new R(errorType.code(),errorType.msg());
		return r;
	}
	public static R error(String code,String msg) {
		R r = new R(code,msg);
		return r;
	}
	/**
	 * 占位符 类似{0}
	 * @param errorType
	 * @param params
	 * @return
	 */
	public static R error(ErrorType errorType,Object... params) {
		return R.error(errorType.code(), errorType.msg(), params);
	}
	
	public static R error(String code,String msg,Object... params) {
		if (null != params && StringUtils.isNotEmpty(msg)) {
			MessageFormat mf = new MessageFormat(msg);
			msg = mf.format(params);
		} 
		R r = new R(code,msg);
		return r;
	}
	public  String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * 将data设置成为map
	 * 
	 * @param key
	 * @param value
	 */
	public void addProperty(String key, String value) {
		if (null == data || !(data instanceof Map)) {
			Map<String, Object> propertyMap = new HashMap<>();
			propertyMap.put(key, value);
			this.setData(propertyMap);
		} else {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>)data;
			map.put(key, value);
		}
	}
}
