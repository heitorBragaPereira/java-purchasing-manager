package com.listproduct.purchasingmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listproduct.purchasingmanager.model.Product;
import com.listproduct.purchasingmanager.model.ProductRepository;

@Service
public class ProductServices {
	@Autowired
	private final ProductRepository repository;

	@Autowired
	public ProductServices(ProductRepository repository) {
		this.repository = repository;
	}

	public Product registerProduct(Product product) {
		return repository.save(product);
	}
}
