package com.capgemini.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.entity.Customer;
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
public class ProductControllerTest extends AbstractTest{

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
	      String uri = "/admin/product/get/all";
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
	   
	   @Test
	   public void createProduct() throws Exception {
	     String uri = "/admin/product/save";
	  	Category category=new Category();
		category.setCatId(1);
		category.setCategoryName("electronics");
		Product product= new Product();
		product.setProductName("Note 7");
		product.setPrice(75000.00);
		product.setColor("Blue");
		product.setDimension("6.1");
		product.setManufacturer("Samsung");
		product.setSpecification("Android OS 13");
		product.setQuantity(1);
		
		product.setCategory(category);
		
		 String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	
	   }      

	   @Test
	   public void updateProduct() throws Exception {
	      String uri = "/admin/product/update";
	      
	      Product product= service.viewProduct(7);
	      product.setColor("Maroon");
	      product.setPrice(99999.99);
	      String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	   
	      
}

	   @Test
	   public void deletePrduct() throws Exception {
	      String uri = "/admin/product/delete/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Product Deleted Successfully ");
	   }
	   
}	   