package com.formacionbdi.spring.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.formacionbdi.spring.app.users.commons.models.entity")
@SpringBootApplication
public class SpringBootServiceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceUsersApplication.class, args);
	}

}
