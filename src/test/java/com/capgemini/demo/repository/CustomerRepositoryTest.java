package com.capgemini.demo.repository;

import java.util.List;
import java.util.Optional;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest			
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repository;
	
	@Test
	void viewCustomers()
	{
		List<Customer> customers = repository.findAll();
		System.out.println(customers);
	}
	
	@Test
	@Order(2)
	@DisplayName("getbyID Customer")
	void  getByIDTest() {
		
		Optional<Customer> customer = repository.findById(1L);	
		System.out.println(customer);
	}
	
	@Test
	@Order(3)
	@DisplayName("update customer")
	void updateTest() {

		Customer customer = new Customer();
		
		customer = repository.getById(1L);
		customer.setFirstName("Jon");
		customer.setLastName("Snow");
		repository.save(customer);
		System.out.println("Updated new details to Customer");
	}
	
	
	
	
	@Test
	@Order(4)
	@DisplayName("delete(ID) customer")
	void deleteByIdTest() {
		
		repository.deleteById(1L);
		System.out.println("customer Deleted Successfully ");
	}
	
	
	@Test
	@Order(5)
	@DisplayName("Adding customer")
	public void addCustomer() {
		
		Address address = new Address();
		address.setBuildingName("Eden Garden");
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
		
		
		repository.save(cs);
		
	}
	
	@Test
	@Order(6)
	@DisplayName("getbyName Customer")
	void  getByNameTest() {
		
		repository.findByFirstNameIgnoreCase("Sourav");
		
	}


	
}	
