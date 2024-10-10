package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Product;

import org.springframework.stereotype.Service;


public interface ProductService {

	Product addProduct(Product product);

	Product viewProduct(Integer productId);

	List<Product> viewAllProducts();

	Product removeProductById(Integer productId);

	Product updateProduct(Product product);

	List<Product> viewProductsByCategory(String cname);

}
