package com.boot.placms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author ZL
 */
@SpringBootApplication
//@MapperScan("com.boot.placms.mapper")
// 如果要扫描多个，用下面这种写法
//@MapperScan(basePackages={"com.boot.placms.mapper", "com.boot.placms.dao"})
public class AwesomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeApplication.class, args);
	}

}

