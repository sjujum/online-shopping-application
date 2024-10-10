package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Cart;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.CartRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Cart Service Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CartServiceImplTest {

	@Autowired
	CartService service;
	@Autowired
	CartRepository repository;
	@Autowired
	ProductService productService;

	
	

	@Test
	@Order(1)
	@DisplayName("Adding products in cart")
	public void addProductTocartTest() {
		Product product=productService.viewProduct(2);
		Cart cart= service.addProductTocart(1, product);
		System.out.println(cart);
	}

	@Test
	@Order(4)
	@DisplayName("Remove Product from cart")
	public void removeProductFromCartTest() {
		Cart cart= service.removeProductFromCart(1, 3);
		System.out.println("Removed product from cart \n"+cart);
	}

	@Test
	@Order(2)
	@DisplayName("Updating product quantity")
	public void updateProductQuantityTest() {
		Cart cart=service.updateProductQuantity(1, 2, 2);
		System.out.println(cart);
		}

	@Test
	@Order(5)
	@DisplayName("Remove all products from cart")
	public void removeAllProductsTest() {
		Cart cart=repository.getById(1);
		service.removeAllProducts(cart);
		System.out.println("removed all products");
	}

	@Test
	@Order(3)
	@DisplayName("All products in cart")
	public void viewAllProductsTest() {
		Cart cart=repository.getById(1);
		List<Product> products=service.viewAllProducts(cart);
		System.out.println(products);
	}

}
