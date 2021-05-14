package com.formacionbdi.spring.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.spring.app.commons.models.entity.Product;
import com.formacionbdi.spring.app.products.models.service.ProductService;

@RestController
public class ProductController {
//	@Autowired
//	private Environment env;
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> list(){
		return productService.findAll().stream().map(p -> {
//			p.setPort(env.getProperty("local.server.port"));
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/detail/{id}")
	public Product detail(@PathVariable Long id) throws Exception {
		Product product = productService.findById(id); 
//		product.setPort(env.getProperty("local.server.port"));
		product.setPort(port);
		
		//Error
		boolean error = false;
		if(error) {
			throw new Exception("Error loading product detail");
		}
		
		//Latency
//		try {
//			Thread.sleep(2000l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return product;
	}	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product existingProduct = productService.findById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		
		return productService.save(existingProduct);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}
}
