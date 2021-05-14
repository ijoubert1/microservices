package com.formacionbdi.spring.app.products.models.service;

import java.util.List;

import com.formacionbdi.spring.app.products.models.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public Product findById(Long id);
	public Product save(Product product);
	public void deleteById(Long id);
}
