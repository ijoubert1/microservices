package com.formacionbdi.spring.app.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.formacionbdi.spring.app.users.commons.SpringBootServiceUsersCommonsApplication;

@EntityScan({"com.formacionbdi.springboot.app.users.commons.models.entity"})
@SpringBootApplication
public class SpringBootServiceUsersApplication {
	private static Logger log = LoggerFactory.getLogger(SpringBootServiceUsersApplication.class);

	public static void main(String[] args) {
		SpringBootServiceUsersCommonsApplication common = new SpringBootServiceUsersCommonsApplication();
		log.info(common.hello());
		SpringApplication.run(SpringBootServiceUsersApplication.class, args);
		
	}

}
