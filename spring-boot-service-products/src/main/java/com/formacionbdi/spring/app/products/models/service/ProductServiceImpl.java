package com.formacionbdi.spring.app.products.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.spring.app.products.models.dao.ProductDao;
import com.formacionbdi.spring.app.products.models.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) dao.findAll();
	}

	@Override
	public Product findById(Long id) {
		return (Product) dao.findById(id).orElse(null);
	}

}
