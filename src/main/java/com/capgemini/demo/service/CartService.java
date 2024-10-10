package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Cart;
import com.capgemini.demo.entity.Product;

public interface CartService {

	Cart addProductTocart(Integer cartId, Product product);

	Cart removeProductFromCart(Integer carrtId, Integer pid);

	Cart saveCart(Cart cart);

	List<Product> viewAllProducts(Cart cart);

	Cart removeAllProducts(Cart cart);

	Cart updateProductQuantity(int cartId, int pid, int quantity);

}
