package com.formacionbdi.spring.app.items.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.spring.app.items.models.Item;
import com.formacionbdi.spring.app.items.models.Product;

@Service("itemServiceImpl")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restClient;

	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restClient.getForObject("http://product-service/list", Product[].class));
		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());

		Product product = restClient.getForObject("http://product-service/detail/{id}", Product.class, pathVariables);
		return new Item(product, quantity);
	}

	@Override
	public Product create(Product product) {
		HttpEntity<Product> body = new HttpEntity<>(product);
		ResponseEntity<Product> response = restClient.exchange("http://product-service/create/", HttpMethod.POST, body,
				Product.class);
		return response.getBody();
	}

	@Override
	public Product update(Product product, Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());

		HttpEntity<Product> body = new HttpEntity<>(product);
		ResponseEntity<Product> response = restClient.exchange("http://product-service/update/{id}/", HttpMethod.PUT,
				body, Product.class, pathVariables);
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		restClient.delete("http://product-service//delete/{id}", pathVariables);
	}
}
