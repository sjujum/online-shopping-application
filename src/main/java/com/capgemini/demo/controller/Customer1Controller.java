package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.service.CustomerService;

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

@RequestMapping("/user/customer")
@RestController
public class Customer1Controller {
	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		return service.saveCustomer(customer);
	
	}
		
	@DeleteMapping("/delete/{customerID}")
	public String deleteCustomerById(@PathVariable("customerID")Long customerID) {
		service.deleteCustomerById(customerID);
		return "Customer Deleted successfully";
	}
	
	@PutMapping("/update/{customerID}")
	public Customer updateCustomer(@PathVariable("customerID") Long customerID, @RequestBody Customer customer) {
		return service.updateCustomer(customerID, customer);
	}
	
	
	
	
	
}
