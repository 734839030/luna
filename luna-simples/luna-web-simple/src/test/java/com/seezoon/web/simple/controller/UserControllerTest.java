package com.seezoon.web.simple.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;

import com.seezoon.web.simple.BaseApplicationTest;

public class UserControllerTest extends BaseApplicationTest{

	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/get")
	                .param("name", "dfenghuang")
	                ).andDo(print()).andReturn().getResponse().getContentAsString();
	            
	}

}
