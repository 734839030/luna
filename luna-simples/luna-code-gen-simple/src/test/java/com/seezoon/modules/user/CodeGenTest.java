package com.seezoon.modules.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seezoon.code.gen.CodeGenApplication;
import com.seezoon.code.gen.service.CodeGenService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CodeGenApplication.class)
public class CodeGenTest {

	@Autowired
	private CodeGenService codeGenService;
	@Test
	public void gen() throws Exception {
		codeGenService.gen("user","/Users/hdf/Downloads");
	}
}
