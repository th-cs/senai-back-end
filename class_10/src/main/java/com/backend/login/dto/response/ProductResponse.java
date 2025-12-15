package com.backend.login.dto.response;

import com.backend.login.entity.Product;

public class ProductResponse {

	// Attributes
	private long id;
	private String name;
	private double price;
	private int quantity;
	private double subtotal;

	// Constructor
	public ProductResponse() {
	}

	public ProductResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.subtotal = this.price * this.quantity;
	}

	// Getters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}
}
