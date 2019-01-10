package com.seezoon.luna.utils.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorUtilTest {

	@Test
	public void testValidate() {
		User u = new User();
		ValidatorUtil.validate(u);
	}

}
