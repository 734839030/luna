package com.seezoon.code.gen.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.seezoon.code.gen.dto.GenInfo;
import com.seezoon.code.gen.service.CodeGenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGenTest {

	@Autowired
	private CodeGenService codeGenService;
	@Test
	public void gen() throws Exception {
		codeGenService.gen("user");
	}
}
