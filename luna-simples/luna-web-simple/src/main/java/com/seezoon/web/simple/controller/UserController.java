package com.seezoon.web.simple.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seezoon.luna.web.controller.BaseController;
import com.seezoon.luna.web.dto.R;
import com.seezoon.web.simple.dto.User;

@RestController
public class UserController extends BaseController{

	@GetMapping("/get")
	public R get(String name) {
		User user = new User();
		user.setAge(11);
		user.setName(name);
		return R.ok(user);
	}
	@RequestMapping("/save")
	public R save(@Validated User user,BindingResult bindingResult) {
		return R.ok(user);
	}
}
