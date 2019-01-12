package com.seezoon.modules.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seezoon.modules.user.service.UserService;

public class UserServiceTest extends BaseApplicationTest{

	@Autowired
	private UserService userService;
	@Test
	public void findList() {
		userService.findList(null);
	}
}
