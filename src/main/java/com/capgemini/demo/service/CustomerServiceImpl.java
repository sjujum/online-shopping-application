package com.capgemini.demo.service;

import java.util.List;
import java.util.Objects;

import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> fetchCustomerList() {
		return repository.findAll();
	}

	@Override
	public Customer fetchCustomerById(Long customerID) {
		
		return repository.getCustomerById(customerID);
	}

	@Override
	public void deleteCustomerById(Long customerID) {
		
		Customer customer= repository.findById(customerID).get();
		customer.setStatus("Inactive");
		repository.save(customer);
		
	}

	

	@Override
	public Customer updateCustomer(Long customerID, Customer customer) {
		Customer cust = repository.findById(customerID).get();
		if(cust.getStatus().equalsIgnoreCase("active")) {
			if(Objects.nonNull(customer.getFirstName()) && !"".equalsIgnoreCase(customer.getFirstName())) {
				cust.setFirstName(customer.getFirstName());
				
			}
			if(Objects.nonNull(customer.getLastName()) && !"".equalsIgnoreCase(customer.getLastName())) {
				cust.setLastName(customer.getLastName());
				
			}
			if(Objects.nonNull(customer.getMobileNumber()) && !"".equalsIgnoreCase(customer.getMobileNumber())) {
				cust.setMobileNumber(customer.getMobileNumber());
				
			}
			if(Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
				cust.setEmail(customer.getEmail());
				
			}
		}else {
			System.out.println("Since the customer is inactive, Customer details will not get updated");
		}
		return repository.save(cust);
	}

	@Override
	public Customer fetchCustomerByName(String firstName) {
		
		return repository.findByFirstNameIgnoreCase(firstName);
		
	}

	

}
