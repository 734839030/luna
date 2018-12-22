package com.seezoon.luna.web.exception;

public enum ErrorCodes implements ErrorType {

	SUCCESS("0","success"),//全局成功
	FAIL("-1","fail")//全局通用业务逻辑错误，msg由调用时候传入
	;
	private String code;
	private String msg;
	
	ErrorCodes(String code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	@Override
	public String code() {
		return code;
	}
	@Override
	public String msg() {
		return msg;
	}
}
