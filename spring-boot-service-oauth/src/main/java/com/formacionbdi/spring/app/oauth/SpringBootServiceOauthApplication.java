package com.formacionbdi.spring.app.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringBootServiceOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceOauthApplication.class, args);
	}

}
