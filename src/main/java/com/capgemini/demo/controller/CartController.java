package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Cart;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/cart")
public class CartController {
	@Autowired
	CartService service;
	
	@PutMapping("/add/{cartId}")
	public ResponseEntity<Cart> addingProductToCart(@PathVariable("cartId") Integer cartId, @RequestBody Product product) {
		Cart cart= service.addProductTocart(cartId, product);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
		Cart savedCart=null;
		savedCart= service.saveCart(cart);
		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>> viewAllProductsInCart(@RequestBody Cart cart){
		List<Product> products=service.viewAllProducts(cart);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cartId}/{pid}")
	public ResponseEntity<Cart> deleteByCartId(@PathVariable("cartId") Integer carrtId,@PathVariable("pid") Integer pid){
		Cart cart= service.removeProductFromCart(carrtId, pid);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/update/{cartId}/{pid}/{quantity}")
	public ResponseEntity<Cart> updateQuantity(@PathVariable("cartId") Integer cartId,@PathVariable("pid") Integer pid,@PathVariable("quantity") Integer quantity){
		Cart cart=service.updateProductQuantity(cartId, pid, quantity);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<Cart> deleteAllProducts(@RequestBody Cart cart){
		Cart cart2=service.removeAllProducts(cart);
		return new ResponseEntity<Cart>(cart2,HttpStatus.OK);
	}
	

}
