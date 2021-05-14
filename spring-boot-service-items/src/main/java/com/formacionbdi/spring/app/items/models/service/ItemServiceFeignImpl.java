package com.formacionbdi.spring.app.items.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.spring.app.items.clients.ProductRestClient;
import com.formacionbdi.spring.app.items.models.Item;
import com.formacionbdi.spring.app.items.models.Product;

@Service("itemServiceFeignImpl")
@Primary
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductRestClient feignClient;

	@Override
	public List<Item> findAll() {
		return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(feignClient.detail(id), quantity);
	}

	@Override
	public Product create(Product product) {
		return feignClient.create(product);
	}

	@Override
	public Product update(Product product, Long id) {
		return feignClient.update(product, id);
	}

	@Override
	public void delete(Long id) {
		feignClient.delete(id);
	}
}
