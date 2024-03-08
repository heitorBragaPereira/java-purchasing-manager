package com.listproduct.purchasingmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listproduct.purchasingmanager.model.Product;
import com.listproduct.purchasingmanager.model.ProductRepository;
import com.listproduct.purchasingmanager.service.ProductServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("product")
public class ProductController {

	private final ProductRepository repository;
	private final ProductServices productServices;

	public ProductController(ProductRepository repository, ProductServices productServices) {
		this.repository = repository;
		this.productServices = productServices;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		List<Product> productList = repository.findAll();
		return productList;
	}

	@PostMapping("/register")
	public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
		Product newProduct = productServices.registerProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productServices.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}
