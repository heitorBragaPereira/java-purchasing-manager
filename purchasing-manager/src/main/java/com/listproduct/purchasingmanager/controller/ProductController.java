package com.listproduct.purchasingmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listproduct.purchasingmanager.model.Product;
import com.listproduct.purchasingmanager.model.ProductRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping
	public List<Product> getAllProducts() {
		List<Product> productList = repository.findAll();
		return productList;
	}
}
