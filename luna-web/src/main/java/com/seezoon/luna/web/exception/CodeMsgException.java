package com.seezoon.luna.web.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * 错误码异常
 * 适用于逻辑层次比较深中断处理，一般不做捕获处理
 * @author hdf
 *
 */
public class CodeMsgException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 响应吗
	 */
	private String code;
	/**
	 * 响应消息
	 */
	private String msg;
	
	public CodeMsgException(String code,String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	public CodeMsgException(String code,String msg,Object... params) {
		super(messageFormat(msg, params));
		this.code = code;
		this.msg = super.getMessage();
	}
	public CodeMsgException(ErrorType errorType) {
		this(errorType.code(), errorType.msg());
	}
	
	public CodeMsgException(ErrorType errorType,Object... params) {
		this(errorType.code(), errorType.msg(),params);
	}
	
	public static String messageFormat(String msg,Object... params) {
		if (null != params && StringUtils.isNotEmpty(msg)) {
			MessageFormat mf = new MessageFormat(msg);
			msg = mf.format(params);
		} 
		return msg;
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
	
}
