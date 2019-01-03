package com.seezoon.web.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.seezoon.luna.utils.thread.MdcUtil;

@SpringBootApplication
public class LunaWebSimpleApplication extends  SpringBootServletInitializer{

	public static void main(String[] args) {
		MdcUtil.push();
		SpringApplication.run(LunaWebSimpleApplication.class, args);
	}
}
