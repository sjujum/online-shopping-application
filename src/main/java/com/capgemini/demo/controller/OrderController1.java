package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Order;
import com.capgemini.demo.service.OrderService;

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

@RequestMapping("/admin/order")
@RestController
public class OrderController1 {

	@Autowired
	private OrderService service;
	
	@GetMapping("/get/{orderID}")
	public ResponseEntity<Order> getOrderByID(@PathVariable("orderID") Long orderID) {
		Order order = service.viewOrder (orderID);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orderList = service.viewAllOrders();
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}
		
	
	@GetMapping("/get/location/{pincode}")
	public Order getOrderByLocation(@PathVariable("pincode") String pincode)
	{
		return service.getOrderByLocation(pincode);
	}
	 
	@PutMapping("/update/{orderID}")
	public Order updateOrder(@PathVariable("orderID")Long orderID, @RequestBody Order order)
	{
		return service.updateOrder(orderID, order);
	}
	  
	
	@GetMapping("/get/user/{customerID}")
	ResponseEntity<List<Order>> getUserID(@PathVariable("customerID") Long customerID){
		List<Order> rtnObj = service.viewOrderByUserId(customerID);
		return new ResponseEntity<List<Order>>(rtnObj, HttpStatus.OK);
	}
	 
	
}
