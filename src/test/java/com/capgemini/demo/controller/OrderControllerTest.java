package com.capgemini.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.entity.Order;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.OrderRepository;
import com.capgemini.demo.service.AddressService;
import com.capgemini.demo.service.CustomerService;
import com.capgemini.demo.service.OrderService;
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
public class OrderControllerTest extends AbstractTest {
	 @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Autowired  // injecting mock mvc engine into the test 
	    private MockMvc mvc;
	   
	   
	   @Autowired
		OrderService service;
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		AddressService addressService;
		
		@Autowired
		ProductService productService;
		
		@Autowired
		OrderRepository repository;
		
	   @Test
	   public void getOrderList() throws Exception {
	      String uri = "/admin/order/get/all";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Order[] orderlist = super.mapFromJson(content, Order[].class);
	      assertTrue(orderlist.length > 0);
	      for(int i=0;i<orderlist.length;i++)
	    	  System.out.println(orderlist[i]);
	   }
	   
	   
	   @Test
	   public void createOrder() throws Exception {
	      String uri = "/user/order/save";
	      
			Order order=new Order();
			Customer c1 = customerService.fetchCustomerById(1L);
			
			Address a1 = addressService.fetchAddressById(1L);
			
			Product p1 = productService.viewProduct(6);
			
			
			order.setOrderDate("29/08/2022");
			order.setOrderStatus("Biling");
			order.setCustomer(c1);
			order.setProduct(p1);
			order.setAddress(a1);

			String inputJson = super.mapToJson(order);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);   			

	      
	     }
	   
	   
	   @Test
	   public void updateOrder() throws Exception {
	      String uri = "/admin/order/update/2";
	      

			Order order = service.viewOrder(2L);
			
			order.setOrderStatus("Unpaid");
			
			String inputJson = super.mapToJson(order);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	   }
	   
	   
	   @Test
	   public void deleteOrder() throws Exception {
	      String uri = "/user/order/delete/8";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Order Deleted Successfully ");
	   }

}
