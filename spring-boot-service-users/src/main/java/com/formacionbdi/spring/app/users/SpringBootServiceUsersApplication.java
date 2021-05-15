package com.formacionbdi.spring.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

@SpringBootApplication
@EntityScan(basePackageClasses = {User.class}) 
@Import({com.formacionbdi.spring.app.users.commons.models.entity.User.class, com.formacionbdi.spring.app.users.commons.models.entity.Role.class})
public class SpringBootServiceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceUsersApplication.class, args);
	}

}
