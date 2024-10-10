package com.capgemini.demo.service;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.repository.CustomerRepository;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@DisplayName("Customer Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CustomerServiceImplTest {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerRepository repository;
	
	@Test
	@Order(1)
	@DisplayName("Find all customers")
	void findAll() {
		List<Customer> customer = service.fetchCustomerList();
		System.out.println(customer);
	
	}
	
	@Test
	@Order(2)
	@DisplayName("getbyID Customer")
	void  getByIDTest() {
		Customer customer = service.fetchCustomerById(1L);
		
		System.out.println(customer);
	}
	
	@Test
	@Order(3)
	@DisplayName("update customer")
	void updateTest() {
		Customer customer = service.fetchCustomerById(1L);
		customer.setFirstName("Jon");
		customer.setLastName("Snow");
		repository.save(customer);
		System.out.println("Updated new details to Customer");
	}
	
	
	
	
	@Test
	@Order(4)
	@DisplayName("delete(ID) customer")
	void deleteByIdTest() {
		service.deleteCustomerById(2L);
	
		System.out.println("customer Deleted Successfully ");
	}
	
	
	@Test
	@Order(5)
	@DisplayName("Adding customer")
	public void addCustomer() {
		
		Address address = new Address();
		address.setBuildingName("EG");
		address.setCity("Kolkata");
		address.setCountry("INDIA");
		address.setPincode("777444");
		address.setState("West Bengal");
		address.setStreetNo("Park Street");
		
		Customer cs  = new Customer();
		cs.setAddress(address);
		cs.setEmail("vys@gmail.com");
		cs.setFirstName("Saurav");
		cs.setLastName("Ganguly");
		cs.setMobileNumber("7897897891");
		
		service.saveCustomer(cs);
	}
	
	
	@Test
	@Order(6)
	@DisplayName("getbyName Customer")
	void  getByNameTest() {
		Customer customer = service.fetchCustomerByName("Nishant");
		
		System.out.println(customer);
	}

	
	
}
