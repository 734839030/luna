package com.seezoon.service.simple.service;

import static org.junit.Assert.fail;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.seezoon.service.simple.BaseApplicationTest;
import com.seezoon.service.simple.entity.User;

public class UserServiceTest extends BaseApplicationTest{

	@Autowired
	private UserService userService;
	@Test
	public void testSave() {
		for (int i =0;i<1;i++) {
			User t = new User();
			t.setId(RandomStringUtils.randomAlphanumeric(32));
			t.setName("hdf" + i);
			userService.save(t);
		}
	}

	@Test
	public void testUpdateSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPageTIntIntBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPageTIntInt() {
		logger.debug("testFindByPageTIntInt:{}",JSON.toJSONString(userService.findByPage(null, 2, 10)));
	}

}
