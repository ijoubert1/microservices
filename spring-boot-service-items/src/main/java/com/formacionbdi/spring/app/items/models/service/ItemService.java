package com.formacionbdi.spring.app.items.models.service;

import java.util.List;

import com.formacionbdi.spring.app.items.models.Item;
import com.formacionbdi.spring.app.items.models.Product;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer quantity);
	public Product save(Product product);
	public Product update(Product product, Long id);
	public void delete(Long id);
}
