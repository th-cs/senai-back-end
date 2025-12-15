package com.backend.login.service;

import com.backend.login.dto.request.ProductRequest;
import com.backend.login.entity.Product;
import com.backend.login.dto.response.ProductResponse;
import com.backend.login.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	// Attribute
	private final ProductRepository productRepository;

	// Constructor
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Get all products
	public List<ProductResponse> listAllProducts() {
		List<Product> productsList = productRepository.findAll();
		List<ProductResponse> productsResponseList = new ArrayList<>();

		for (Product product : productsList) {
			productsResponseList.add(new ProductResponse(product));
		}

		return productsResponseList;
	}

	// Get product by id
	public Optional<ProductResponse> listProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		ProductResponse productResponse = new ProductResponse();

		if (productOptional != null) {
			Product product = productOptional.get();
			productResponse = new ProductResponse(product);
		}
		return Optional.of(productResponse);
	}

	// Add new product
	public String addProduct(ProductRequest addedProduct) {
		Product product = new Product(addedProduct.getName(),
				addedProduct.getPrice(), addedProduct.getQuantity());
		productRepository.save(product);
		return "Produto adicionado com sucesso!";
	}

	// Update quantity only
	public String updateProduct(Long id, ProductRequest updatedProduct) {
		Optional<Product> existingProduct = productRepository.findById(id);

		if (existingProduct.isPresent()) {
			Product product = existingProduct.get();
			product.setQuantity(updatedProduct.getQuantity());
			productRepository.save(product);
			return "Produto atualizado com sucesso!";
		} else {
			return "Produto não encontrado!";
		}
	}

	// Delete product
	public String deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return "Produto excluído com sucesso!"; // 204
		} else {
			return "Produto não encontrado!"; // 404
		}
	}
}
