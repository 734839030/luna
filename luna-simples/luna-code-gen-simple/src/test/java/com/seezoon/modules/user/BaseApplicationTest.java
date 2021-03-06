package com.seezoon.modules.user;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.seezoon.modules.user.LunaCodeGenApplication;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes=LunaCodeGenApplication.class)
@Rollback(false)
public abstract class BaseApplicationTest {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

}