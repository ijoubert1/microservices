package com.formacionbdi.spring.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
//@RibbonClient(name="product-service")
@EnableFeignClients
@SpringBootApplication
public class SpringBootServiceItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceItemsApplication.class, args);
	}

}
