package com.formacionbdi.spring.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.spring.app.products.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long>{
	
}
