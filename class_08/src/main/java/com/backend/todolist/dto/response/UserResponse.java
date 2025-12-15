package com.backend.todolist.dto.response;

import com.backend.todolist.entity.User;

public class UserResponse {

	// Attributes
	private long id;
	private String name;
	private String email;

	// Constructor
	public UserResponse() {
	}

	public UserResponse(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
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

}
