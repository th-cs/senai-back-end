package com.backend.login.controller;

import com.backend.login.entity.Product;
import com.backend.login.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

	// Attribute
	private final ProductRepository productRepository;

	// Constructor
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Endpoints
	@GetMapping (value = "/all")
	public List<Product> listAllProducts() {
		List<Product> productsList = productRepository.findAll();
		return productsList;
	}

	@GetMapping (value = "/find/{id}")
	public Optional<Product> listProductById(@PathVariable Long id) {
		return productRepository.findById(id);
	}

	@PostMapping (value = "/add")
	public ResponseEntity<?> addProduct(@RequestBody Product addedProduct) {
		Product product = new Product(addedProduct.getName(),
			addedProduct.getPrice(), addedProduct.getQuantity());
		productRepository.save(product);
		return ResponseEntity.ok("Produto adicionado com sucesso!");
	}

	// Update quantity only
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id,
		@RequestBody Product updatedProduct) {
		Optional<Product> existingProduct = productRepository.findById(id);

		if (existingProduct.isPresent()) {
			Product product = existingProduct.get();
			product.setQuantity(updatedProduct.getQuantity());
			productRepository.save(product);
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return ResponseEntity.noContent().build(); // 204
		} else {
			return ResponseEntity.notFound().build(); // 404
		}
	}
}
