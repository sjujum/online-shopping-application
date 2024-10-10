package com.capgemini.demo.controller;

import com.capgemini.demo.entity.Order;
import com.capgemini.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/order")
@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		
		Order saved = null;
		saved = service.addOrder(order);
		return new ResponseEntity<Order>(saved, HttpStatus.OK);
	}
	
	@GetMapping("/get/{orderID}")
	public ResponseEntity<Order> getOrderByID(@PathVariable("orderID") Long orderID) {
		Order order = service.viewOrder (orderID);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Order> deleteOrderById(@PathVariable("orderId") Long orderID) {
		Order order= service.removeOrderById(orderID);
		if(order==null) {
			return new ResponseEntity("Sorry! Orders are not available!",HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
		 
	
}

