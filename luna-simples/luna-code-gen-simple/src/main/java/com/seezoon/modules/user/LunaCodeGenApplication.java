package com.seezoon.modules.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.seezoon.luna.dao.BaseDao;

@SpringBootApplication
@MapperScan(markerInterface=BaseDao.class,basePackageClasses=LunaCodeGenApplication.class)
@EnableTransactionManagement(proxyTargetClass=true)
public class LunaCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunaCodeGenApplication.class, args);
	}
}
