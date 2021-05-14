package com.formacionbdi.spring.app.commons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringBootServiceCommonsApplication {
//This service will be a library, not an application
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootServiceCommonsApplication.class, args);
//	}

}
