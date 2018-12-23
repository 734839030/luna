package com.seezoon.luna.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seezoon.luna.utils.common.DateUtils;
import com.seezoon.luna.web.dto.R;
import com.seezoon.luna.web.exception.CodeMsgException;
import com.seezoon.luna.web.exception.ErrorCodes;

@ControllerAdvice
public class AdviceController {

	/**
	 * 日志对象
	 */
	private static Logger logger = LoggerFactory.getLogger(AdviceController.class);
	
	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
		});
	}
	

	/**
	 * Spring Assert 断言错误
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)
	public R respoRneException(IllegalArgumentException e) {
		logger.error("illegal argument exception ", e);
		R r = R.error(ErrorCodes.PARAM_ILLEGAL_ERROR, e.getMessage());
		return r;
	}
	@ResponseBody
	@ExceptionHandler(CodeMsgException.class)
	public R respoRneException(CodeMsgException e) {
		logger.error("codeMsg exception ", e);
		R r = R.error(e.getCode(), e.getMsg());
		return r;
	}
	@ResponseBody
	@ExceptionHandler(BindException.class)
	public R bindException(BindException e) {
		logger.error("bind exception ", e);
		R r = R.error(ErrorCodes.PARAM_BIND_ERROR, "参数绑定错误:{0}",e.getMessage());
		return r;
	}
	/**
	 * 可以细化异常，spring 从小异常抓，抓到就不往后走
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public R exception(Exception e) {
		logger.error("global exception ", e);
		R r = R.error(ErrorCodes.UNKNOWN,e.getMessage());
		return r;
	}
}
