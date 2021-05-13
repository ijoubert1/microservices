package com.formacionbdi.spring.app.items;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("restTemplateClient")
	public RestTemplate registrationRestTemplate() {
		return new RestTemplate();
	}

}
