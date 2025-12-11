package com.backend.todolist.controller;

import com.backend.todolist.entity.User;
import com.backend.todolist.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping (value = "/users")
public class UserController {

	// Attribute
	private final UserRepository userRepository;

	// Constructor
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Endpoint
	@GetMapping
	public List<User> listAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
}
