package com.seezoon.luna.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.seezoon.luna.web.exception.CodeMsgException;
import com.seezoon.luna.web.exception.ErrorCodes;


/**
 * 参数校验切面
 * 
 * @author hdf 2017年9月25日
 */
@Aspect
public class ParamsValidateAspect {

	@Pointcut("execution(* com.seezoon.luna.web.controller.BaseController+.*(..))")
	private void anyMethod() {
	}

	@Around("anyMethod()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object[] args = point.getArgs();
		if (null != args && args.length > 0) {
			for (Object arg : args) {
				if (arg instanceof BindingResult) {
					BindingResult br = (BindingResult) arg;
					if (br.hasErrors()) {
						FieldError fieldError = br.getFieldErrors().get(0);
						throw new CodeMsgException(ErrorCodes.PARAM_INVALID, fieldError.getField(), fieldError.getDefaultMessage());
					}
				}
			}
		}
		return point.proceed();
	}
}
