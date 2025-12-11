package com.backend.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table (name = "tb_products")
public class Product {

	// Attributes
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "name", length = 50, nullable = false)
	private String name;
	@Column (name = "price", nullable = false)
	private double price;
	@Column (name = "quantity", nullable = false)
	private int quantity;

	// Constructors
	public Product() {
	}

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	// Setters
	public void setId(long id) {
		this.id = id;
	}

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
