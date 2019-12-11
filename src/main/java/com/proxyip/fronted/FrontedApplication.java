package com.proxyip.fronted;

import com.proxyip.fronted.model.custom.Token;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
@MapperScan("com.proxyip.fronted.dao")
public class FrontedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontedApplication.class, args);
	}

	@Bean
	public Token token() {
		Token token = new Token();
		token.setTokens(Collections.synchronizedList(new ArrayList<>()));
		return token;
	}

}
