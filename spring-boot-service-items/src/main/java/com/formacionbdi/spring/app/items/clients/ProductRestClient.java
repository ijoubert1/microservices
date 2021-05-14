package com.formacionbdi.spring.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacionbdi.spring.app.commons.models.entity.Product;

@FeignClient(name = "product-service")
public interface ProductRestClient {
	
	@GetMapping("/list")
	public List<Product> list();
	
	@GetMapping("/detail/{id}")
	public Product detail(@PathVariable Long id);
	
	@PostMapping("/create")
	public Product create(@RequestBody Product product);
	
	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id);
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id);
}
