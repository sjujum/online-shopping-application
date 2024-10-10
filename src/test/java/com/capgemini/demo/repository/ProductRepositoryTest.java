package com.capgemini.demo.repository;

import java.util.List;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.entity.Product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Product Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	ProductRepository repository;
	
	@Test
	@Order(4)
	@DisplayName("Display all the products")
	public void viewAllProductsTest() {
		List<Product> products = repository.findAll();
		System.out.println(products);
		
	}
	
	@Test
	@Order(1)
	@DisplayName("Adding the product")
	public void addProductTest() {
		Category category=new Category();
		category.setCatId(2);
		Product product=new Product();
		product.setProductName("Note 2");
		product.setPrice(15000.00);
		product.setColor("Grey");
		product.setDimension("5.11'");
		product.setManufacturer("Samsung");
		product.setSpecification("Android OS 9");
		product.setQuantity(1);
		
		
		repository.save(product);
		
		
		
	};
	
	
	@Test
	@Order(2)
	@DisplayName("Updating the Product")
	public void updateProductTest() {
		
		Product product= repository.getById(6);
		product.setDimension("6.1");
		
		repository.save(product);
		System.out.println(product);
	};
	
	@Test
	@Order(3)
	@DisplayName("Get Product By ID")
	public void viewProductTest() {
		
		
		Product pdt=repository.getById(7);
		System.out.println(pdt);
		
	};
	
	@Test
	@Order(6)
	@DisplayName("View Products by category")
	public void viewProductsByCategoryTest() {
		
		List<Product> products2= repository.findAll();
		System.out.println(products2);
	};
	
	@Test
	@Order(5)
	@DisplayName("Removing Prduct by id")
	public void removeProductByIdTest() {
		repository.deleteById(4);
		System.out.println("Product 4 removed successfully!");
	};


}
