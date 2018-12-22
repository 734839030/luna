package com.seezoon.luna.web.dto;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class RTest {

	@Test
	public void testErrorStringStringObjectArray() {
		R r = R.error("1", "{0}", "hello");
		System.out.println(JSON.toJSONString(r));
	}

}
