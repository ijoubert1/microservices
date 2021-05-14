package com.formacionbdi.spring.app.items.models;

import com.formacionbdi.spring.app.commons.models.entity.Product;

public class Item {

	private Product product;
	private Integer quantity;

	public Item() {
		super();
	}

	public Item(Product product, Integer cantidad) {
		super();
		this.product = product;
		this.quantity = cantidad;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotal() {
		return product.getPrice() * quantity.doubleValue();
	}

}
