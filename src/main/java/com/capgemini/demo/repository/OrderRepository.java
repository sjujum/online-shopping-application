package com.capgemini.demo.repository;

import java.util.List;

import com.capgemini.demo.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findByAddressPincode(String pincode);

	List<Order> findByCustomerCustomerID(Long customerID); 
	
}
