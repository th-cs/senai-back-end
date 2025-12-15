package com.backend.login.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class ProductRequest {

	// Attributes
	@NotBlank (message = "Informe o nome do produto")
	private String name;
	@NotNull (message = "Informe o preço do produto")
	private double price;
	@Min (value = 1, message = "A quantidade mínima é 1")
	@Max (value = 1000, message = "A quantidade máxima é 1000")
	private int quantity;

	// Constructor
	public ProductRequest() {
	}

	public ProductRequest(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
