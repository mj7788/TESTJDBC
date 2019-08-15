package com.xugu.owl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xugu.owl.dao")
public class OwlApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwlApplication.class, args);
	}

}
