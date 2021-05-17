package com.formacionbdi.spring.app.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringBootServiceOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pass = "12345";
		
//		for(int i=0; i<4; i++) {
			System.out.println(passwordEncoder.encode(pass));
			//$2a$10$w4naGkV2HH9UHBog98JXaepQXv.9OOrITl3kjSArMPSWDvO3sNz9S
//		}
	}
}
