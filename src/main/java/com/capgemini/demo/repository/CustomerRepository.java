package com.capgemini.demo.repository;

import com.capgemini.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	public Customer findByFirstNameIgnoreCase(String firstName);
	
	
	@Query(value = "SELECT * FROM customers ld WHERE ld.customerid=?1 AND ld.status = 'active'", 
			nativeQuery = true)
	public Customer getCustomerById(Long customerId);
	
	
}
