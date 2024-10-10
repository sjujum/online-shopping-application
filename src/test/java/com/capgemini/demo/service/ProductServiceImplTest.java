package com.capgemini.demo.service;

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

@DisplayName("Product Test Cases2")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProductServiceImplTest {
	@Autowired
	ProductService service;
	
	@Test
	@Order(4)
	@DisplayName("Display all the products")
	public void viewAllProductsTest() {
		List<Product> products1=service.viewAllProducts();
		System.out.println(products1);
		
	}
	
	@Test
	@Order(1)
	@DisplayName("Adding the product")
	public void addProductTest() {
		Category category=new Category();
		category.setCatId(1);
		category.setCategoryName("Mobile");
		
		Product product=new Product();
		product.setProductName("Note 5");
		product.setPrice(60000.00);
		product.setColor("Black");
		product.setDimension("6");
		product.setManufacturer("Samosung");
		product.setSpecification("Android OS 12");
		product.setQuantity(1);
		
		product.setCategory(category);
		
		service.addProduct(product);
	};
	
	
	@Test
	@Order(2)
	@DisplayName("Updating the Product")
	public void updateProductTest() {
		
		Product product= service.viewProduct(2);
		product.setDimension("6.1");
		
		service.updateProduct(product);
		System.out.println(product);
	};
	
	@Test
	@Order(3)
	@DisplayName("Get Product By ID")
	public void viewProductTest() {
		Product pdt=service.viewProduct(2);
		System.out.println(pdt);
		
	};
	
	@Test
	@Order(6)
	@DisplayName("View Products by category")
	public void viewProductsByCategoryTest() {
		List<Product> products2=service.viewAllProducts();
		System.out.println(products2);
	};
	
	@Test
	@Order(5)
	@DisplayName("Removing Prduct by id")
	public void removeProductByIdTest() {
		service.removeProductById(3);
		System.out.println("Product 4 removed successfully!");
	};


	
}
