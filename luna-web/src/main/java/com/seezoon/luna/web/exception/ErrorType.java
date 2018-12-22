package com.seezoon.luna.web.exception;

/**
 * 业务可以自定义错误码
 * @author hdf
 *
 */
public interface ErrorType {

	public String code();
	public String msg();
}
