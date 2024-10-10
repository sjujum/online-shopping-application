package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.entity.Order;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.AddressRepository;
import com.capgemini.demo.repository.CustomerRepository;
import com.capgemini.demo.repository.OrderRepository;
import com.capgemini.demo.repository.ProductRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Order Tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OrderServiceImplTest {

	@Autowired
	OrderService service;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderRepository repository;
	
	@Test
	@org.junit.jupiter.api.Order(1)
	@DisplayName("Find all orders")
	void findAll() {
		List<Order> order = service.viewAllOrders();
		System.out.println(order);
	}
	
	@Test
//	@Order(3)
	@DisplayName("Get Order By ID")
	public void viewOrderTest() {
		Order ord=service.viewOrder(2L);
		System.out.println(ord);
		
	}
	
	@Test
//	@Order(1)
	@DisplayName("Adding the order")
	public void addOrderTest() {
		
		Order order=new Order();
		Customer c1 = customerService.fetchCustomerById(1L);
		
		
		//Customer c2 = customerRepository.getById(18L);
		//Product p2 = productRepository.getById(1);
		//Address a2 = addressRepo.getById(5L);
		
		Address a1 = addressService.fetchAddressById(2L);
		
		Product p1 = productService.viewProduct(6);
		
		
		order.setOrderDate("29/08/2022");
		order.setOrderStatus("Biling");
		order.setCustomer(c1);
		order.setProduct(p1);
		order.setAddress(a1);
		repository.save(order);
		
	};

	@Test
//	@Order(2)
	@DisplayName("Updating the Order")
	public void updateOrderTest() {
		
		
		Order order = service.viewOrder(2L);
		
		order.setOrderStatus("Unpaid");
		
		repository.save(order);
		System.out.println("Order Updated!");
		System.out.println(order);
		
	};

	@Test
//	@Order(5)
	@DisplayName("Removing Order by id")
	public void removeOrderByIdTest() {
		service.removeOrderById(6L);
		System.out.println("Order 6 removed successfully!");
	};


}
