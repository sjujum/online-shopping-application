package com.capgemini.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Cart;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.CartRepository;
import com.capgemini.demo.repository.CustomerRepository;
import com.capgemini.demo.repository.ProductRepository;
import com.capgemini.demo.service.CartService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest extends AbstractTest {

	 @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	 
		@Autowired
		CartService service;
		@Autowired
		CartRepository repository;
		@Autowired
		ProductRepository productRepository;
		@Autowired
		CustomerRepository customerRepository;

	   @Autowired  // injecting mock mvc engine into the test 
	    private MockMvc mvc;

	   @Test
	   public void getCartList() throws Exception {
	      String uri = "/cart/get";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();	      
	      String content = mvcResult.getResponse().getContentAsString();
	      Cart cart=repository.getById(1);
	      List<Product> products=service.viewAllProducts(cart);
	      assertTrue(products.size()> 0);
	      for(int i=0;i<products.size();i++)
	    	  System.out.println(products.get(i));
	   }
	   
	   @Test
	   public void addProductToCart() throws Exception {
	      String uri = "/cart/add/1";
	      
	  	Product product=productRepository.getById(16);
		Cart cart= service.addProductTocart(1, product);
	      
	      
	      String inputJson = super.mapToJson(cart);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      }


	   
	   @Test
	   public void deleteAllProducts() throws Exception {
	      String uri = "/cart/delete/all";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "All Products Deleted Successfully ");
	   }
	   

}
