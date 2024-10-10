package com.capgemini.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.service.ProductService;

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
public class ProductController2Test extends AbstractTest{

	 @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Autowired  // injecting mock mvc engine into the test 
	    private MockMvc mvc;
	   
		@Autowired
		ProductService service;
	   
	   @Test
	   public void getProductList() throws Exception {
	      String uri = "/user/product/get/all";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Product[] productlist = super.mapFromJson(content, Product[].class);
	      assertTrue(productlist.length > 0);
	      for(int i=0;i<productlist.length;i++)
	    	  System.out.println(productlist[i]);
	      
	      
	      
	   }
	   
}	   