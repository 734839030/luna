package com.seezoon.luna.web.exception;

public enum ErrorCodes implements ErrorType {

	SUCCESS("0","success"),//全局成功
	FAIL("-1","fail"),//全局通用业务逻辑错误，msg由调用时候传入
	//90 开头的错误码
	UNKNOWN("90000","系统错误:{0}"),
	PARAM_ILLEGAL_ERROR("90001","参数不合法:{0}"),
	PARAM_BIND_ERROR("90002","参数绑定错误:{0}"),
	PARAM_INVALID("90003","参数校验错误:{0} {1}"),
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
