package com.capgemini.demo.repository;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.service.AddressService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressRepositoryTest {


	@Autowired
	AddressService service;
	
	@Autowired
	AddressRepository repository;
	
	
	@Test
	@Order(1)
	@DisplayName("Find all addresses")
	void findAll() {
		List<Address> address = repository.findAll();
		System.out.println(address);
	
	}
	
	@Test
	@Order(2)
	@DisplayName("getbyID Address")
	void  getByIDTest() {
		Address address = repository.getById(2L); 
		System.out.println(address);
	}
	
	@Test
	@Order(3)
	@DisplayName("update address")
	void updateTest() {
		Address address = repository.getById(3L);
		address.setBuildingName("SeaView Palace");
		address.setCity("Mumbai");
		repository.save(address);
		System.out.println("Updated new details to Address");
	}
	
	
	@Test
	@Order(4)
	@DisplayName("delete(ID) address")
	void deleteByIdTest() {
		service.deleteAddressById(10L);
	
		System.out.println("Address Deleted Successfully ");
	}
	
	
	@Test
	@Order(5)
	@DisplayName("Adding address")
	public void addAddress() {
		
		Address address = new Address();
		address.setBuildingName("Sriram Park");
		address.setCity("Kozhikode");
		address.setCountry("INDIA");
		address.setPincode("774544");
		address.setState("Kerala");
		address.setStreetNo("Back Street");
		repository.save(address);
		
	}
	

}
