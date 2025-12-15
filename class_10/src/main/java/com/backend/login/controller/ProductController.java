package com.backend.login.controller;

import com.backend.login.dto.request.ProductRequest;
import com.backend.login.service.ProductService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

	// Attribute
	private final ProductService productService;

	// Constructor
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Endpoints
	@GetMapping (value = "/all")
	public ResponseEntity<?> listAllProducts() {
		return ResponseEntity.ok(productService.listAllProducts());
	}

	@GetMapping (value = "/find/{id}")
	public ResponseEntity<?> listProductById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.listProductById(id));
	}

	@PostMapping (value = "/add")
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest addedProduct) {
		return ResponseEntity.ok(productService.addProduct(addedProduct));
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id,
		@Valid @RequestBody ProductRequest updatedProduct) {
		return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
	}

	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(productService.deleteProduct(id));
	}
}
