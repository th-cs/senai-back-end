package com.backend.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table (name = "tb_users")
public class User {

	// Attributes
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "name", length = 100)
	private String name;
	@Column (name = "email", length = 50, unique = true)
	private String email;
	@Column (name = "password", length = 50)
	private String password;

	// Constructors
	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	// Setters
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
