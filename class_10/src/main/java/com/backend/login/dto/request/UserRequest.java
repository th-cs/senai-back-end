package com.backend.login.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

	// Attributes
	@NotBlank (message = "O nome não pode ser nulo")
	private String name;
	@NotBlank (message = "O email não pode ser nulo")
	private String email;
	@Size (min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
	private String password;

	// Constructors
	public UserRequest() {
	}

	public UserRequest(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters
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
