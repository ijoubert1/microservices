package com.formacionbdi.spring.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.spring.app.items.models.Product;

@FeignClient(name = "product-service", url = "localhost:8001")
public interface ProductRestClient {
	
	@GetMapping("/list")
	public List<Product> list();
	
	@GetMapping("/detail/{id}")
	public Product detail(@PathVariable Long id);
}
