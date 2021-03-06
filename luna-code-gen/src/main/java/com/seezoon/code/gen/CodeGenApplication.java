package com.seezoon.code.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.seezoon.luna.dao.BaseDao;

@SpringBootApplication
@MapperScan(markerInterface=BaseDao.class,basePackages="com.seezoon.code.gen")
@EnableTransactionManagement(proxyTargetClass=true)
public class CodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenApplication.class, args);
	}
}
