package com.capgemini.demo.service;

import java.util.List;
import java.util.Objects;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.entity.Order;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.AddressRepository;
import com.capgemini.demo.repository.CustomerRepository;
import com.capgemini.demo.repository.OrderRepository;
import com.capgemini.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	AddressRepository addressrepo;
	
	@Override
	public Order addOrder(Order order) {
		
		Product p1 = productrepo.getProductById(order.getProduct().getProductId());
		Customer c1 = customerrepo.getCustomerById(order.getCustomer().getCustomerID());
		Address a1 = addressrepo.getById(order.getAddress().getAddressID());
		if(c1==null) {
			System.out.println("Customer is inactive");
		}else if (p1==null) {
			System.out.println("product is unavailable");
		}
		else {
			order.setProduct(p1);
			order.setCustomer(c1);
			order.setAddress(a1);
			return repository.save(order);
		}
		return null;
	}

	@Override
	public Order viewOrder(Long orderID) {
		return repository.findById(orderID).get();
	}

	@Override
	public List<Order> viewAllOrders() {
		return repository.findAll();
	}

	@Override
	public Order removeOrderById(Long orderID) {
		Order exists = repository.findById(orderID).get();
		Order resultOrder=null;
		if(exists != null) {
			repository.deleteById(orderID);
			resultOrder=exists;
		}
		return resultOrder;
	}

	@Override
	public Order getOrderByLocation(String pincode) {
		
		return repository.findByAddressPincode(pincode);
	}

	@Override
	public Order updateOrder(Long orderID, Order order) {
		
		Order o1 = repository.findById(orderID).get();
		if(Objects.nonNull(order.getOrderStatus()) && !"".equalsIgnoreCase(order.getOrderStatus())) {
			o1.setOrderStatus(order.getOrderStatus());
		}
		
		return repository.save(o1);
}

	@Override
	public List<Order> viewOrderByUserId(Long customerID) {
		return repository.findByCustomerCustomerID(customerID);
	}
	
}