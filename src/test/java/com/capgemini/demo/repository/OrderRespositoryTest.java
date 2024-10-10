package com.capgemini.demo.repository;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.entity.Order;
import com.capgemini.demo.entity.Product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Order Tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OrderRespositoryTest {
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	AddressRepository addressRepo;
	
	
	
	@Test
	@org.junit.jupiter.api.Order(1)
	@DisplayName("Find all orders")
	void findAll() {
		List<Order> order = repo.findAll();
		System.out.println(order);
	}
	
	@Test
//	@Order(3)
	@DisplayName("Get Order By ID")
	public void viewOrderTest() {
		Order ord=repo.getById(2L);
		System.out.println(ord);
		
	}
	
	@Test
//	@Order(1)
	@DisplayName("Adding the order")
	public void addOrderTest() {
		
		Order order=new Order();
	
		
		
		
		Customer c2 = customerRepository.getById(3L);
		Product p2 = productRepository.getById(8);
		Address a2 = addressRepo.getById(2L);
		
		
		
		order.setOrderDate("29/08/2022");
		order.setOrderStatus("Biling");
		order.setCustomer(c2);
		order.setProduct(p2);
		order.setAddress(a2);
		repo.save(order);
		
	};

	@Test
//	@Order(2)
	@DisplayName("Updating the Order")
	public void updateOrderTest() {
		
		
		
		Order order = repo.getById(2L);
		
		order.setOrderStatus("Unpaid");
		
		repo.save(order);
		System.out.println("Order Updated!");
		System.out.println(order);
		
	};

	@Test
//	@Order(5)
	@DisplayName("Removing Order by id")
	public void removeOrderByIdTest() {
		
		repo.deleteById(3L);
		System.out.println("Order 6 removed successfully!");
	};


}
