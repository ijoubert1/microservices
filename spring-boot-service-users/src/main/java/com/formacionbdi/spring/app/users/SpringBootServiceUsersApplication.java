package com.formacionbdi.spring.app.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.formacionbdi.spring.app.users.commons.SpringBootServiceUsersCommonsApplication;
import com.formacionbdi.spring.app.users.commons.models.entity.Role;
import com.formacionbdi.spring.app.users.commons.models.entity.User;

//@EntityScan({"com.formacionbdi.springboot.app.users.commons.models.entity"})
@ComponentScan
@SpringBootApplication
public class SpringBootServiceUsersApplication {
	private static Logger log = LoggerFactory.getLogger(SpringBootServiceUsersApplication.class);

	public static void main(String[] args) {
		SpringBootServiceUsersCommonsApplication common = new SpringBootServiceUsersCommonsApplication();
		log.info(common.hello());
		
		User user = new User();
		user.setName("Test user");
		log.info(user.getName());
		
		Role role = new Role();
		role.setName("Test role");
		log.info(role.getName());
		
		SpringApplication.run(SpringBootServiceUsersApplication.class, args);
		
	}

}
