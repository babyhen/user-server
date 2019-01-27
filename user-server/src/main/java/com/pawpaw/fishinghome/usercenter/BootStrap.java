package com.pawpaw.fishinghome.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.pawpaw.fishinghome.usercenter.dao")
@EnableAspectJAutoProxy
public class BootStrap {
	private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

	public static void main(String[] args) {
		logger.info("开始启动服务");
		SpringApplication.run(BootStrap.class, args);
	}
}
