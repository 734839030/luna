package com.seezoon.service.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.seezoon.luna.dao.BaseDao;

@SpringBootApplication
//basePackageClasses 扫描该类所在包及子包  basePackages 直接指定包
@MapperScan(markerInterface=BaseDao.class,basePackageClasses=LunaServiceSimpleApplication.class)
@EnableTransactionManagement(proxyTargetClass=true)
public class LunaServiceSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunaServiceSimpleApplication.class, args);
	}
}
