package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public List<Customer> fetchCustomerList();

	public Customer fetchCustomerById(Long customerID);

	public void deleteCustomerById(Long customerID);

	public Customer updateCustomer(Long customerID, Customer customer);

	public Customer fetchCustomerByName(String firstName);
	
}
