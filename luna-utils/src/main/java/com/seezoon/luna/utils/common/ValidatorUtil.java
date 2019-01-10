package com.seezoon.luna.utils.common;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.common.collect.Maps;

public class ValidatorUtil {

	private static final ValidatorFactory factory;
    public static final Validator validator;
    
    static {
    	factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    public static void validate(Object object,Class<?>... groups) {
    	Set<ConstraintViolation<Object>> errorSet = validator.validate(object);
    	if (!errorSet.isEmpty()) {
    		for (ConstraintViolation<Object> violation: errorSet) {
    			throw new IllegalArgumentException(violation.getPropertyPath() + violation.getMessage());
    		}
    	}
    }
    public static Map<String,String> getValidateInfo(Object object,Class<?>... groups) {
    	Set<ConstraintViolation<Object>> errorSet = validator.validate(object);
    	if (!errorSet.isEmpty()) {
    		Map<String,String> errors = Maps.newHashMap();
    		for (ConstraintViolation<Object> violation: errorSet) {
    			errors.put(violation.getPropertyPath().toString(), violation.getMessage());
    		}
    		return errors;
    	}
    	return Collections.EMPTY_MAP;
    }
}
