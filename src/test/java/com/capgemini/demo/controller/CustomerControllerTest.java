package com.capgemini.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;

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
public class CustomerControllerTest extends AbstractTest {
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Autowired  // injecting mock mvc engine into the test 
	    private MockMvc mvc;
	   
	   @Test
	   public void getCustomerList() throws Exception {
	      String uri = "/admin/customer/get";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Customer[] customerlist = super.mapFromJson(content, Customer[].class);
	      assertTrue(customerlist.length > 0);
	      for(int i=0;i<customerlist.length;i++)
	    	  System.out.println(customerlist[i]);
	   }
	   
	   @Test
	   public void createCustomer() throws Exception {
	      String uri = "/admin/customer/save";
	      

	      Address address = new Address();
			address.setBuildingName("Eden garden");
			address.setCity("Kharghar");
			address.setCountry("INDIA");
			address.setPincode("410210");
			address.setState("MH");
			address.setStreetNo("Sector 5");
			
	      
		Customer customer = new Customer();
			customer.setFirstName("Rahul");
			customer.setLastName("Sodhi");
			customer.setMobileNumber("8108444345");
			customer.setEmail("1headkjghakde3@ymail.com");
			customer.setAddress(address);
	      
	      
	      String inputJson = super.mapToJson(customer);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      }
	   
	   
	   @Test
	   public void updateCustomer() throws Exception {
	      String uri = "/admin/customer/update/1";
	      Customer customer = new Customer();
	      customer.setFirstName("Melon");
	      String inputJson = super.mapToJson(customer);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	   }
	   @Test
	   public void deleteCustomer() throws Exception {
	      String uri = "/admin/customer/delete/21";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Customer Deleted Successfully ");
	   }
	}