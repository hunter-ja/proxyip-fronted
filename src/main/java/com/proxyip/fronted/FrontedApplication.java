package com.proxyip.fronted;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.proxyip.fronted.dao")
public class FrontedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontedApplication.class, args);
	}

}
