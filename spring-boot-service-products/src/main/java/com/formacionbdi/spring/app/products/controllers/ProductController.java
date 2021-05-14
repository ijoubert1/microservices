package com.formacionbdi.spring.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.spring.app.products.models.entity.Product;
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
		
		boolean error = false;
		if(error) {
			throw new Exception("Error loading product detail");
		}
		return product;
	}	
}
