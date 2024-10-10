package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Product;
import com.capgemini.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/product")
public class ProductController2 {
	@Autowired
	private ProductService service;
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
		Product product = service.viewProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = service.viewAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
}
