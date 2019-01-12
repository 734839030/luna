package com.seezoon.modules.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seezoon.modules.user.entity.User;
import com.seezoon.modules.user.service.UserService;

public class UserServiceTest extends BaseApplicationTest{

	@Autowired
	private UserService userService;
	@Test
	public void findList() {
		User user = new User();
		user.setId("111");
		user.setName("11");;
		//userService.save(user);
		userService.findById(user);
	}
}
