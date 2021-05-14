package com.formacionbdi.spring.app.items.controllers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.spring.app.items.models.Item;
import com.formacionbdi.spring.app.items.models.Product;
import com.formacionbdi.spring.app.items.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {
	
	private static Logger log = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	@Qualifier("itemServiceImpl")
	private ItemService itemService;
	
	@Value("${config.text}")
	private String text;
	
	@GetMapping("/list")
	public List<Item> list(){
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/detail/{id}/quantity/{quantity}")
	public Item detail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}
	
	public Item alternativeMethod(Long id, Integer quantity) {
		Product product = new Product();
		product.setId(id);
		product.setName("Alternative product");
		product.setCreatedAt(Calendar.getInstance().getTime());
		product.setPort("");
		product.setPrice(100d);
		
		Item item = new Item(product, quantity); 
		return item;
	}
	
	@GetMapping("/get-config")
	public ResponseEntity<?> getConfig(@Value("${server.port}") String port) {
		log.info(text);
		Map<String, String> json = new HashMap<>();
		json.put("text", text);
		json.put("port", port);
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
}
