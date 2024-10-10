package com.capgemini.demo.service;



import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.repository.AddressRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@DisplayName("Address Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AddressServiceImplTest {

	@Autowired
	AddressService service;
	
	@Autowired
	AddressRepository repository;
	
	@Test
	@Order(1)
	@DisplayName("Find all addresses")
	void findAll() {
		List<Address> address = service.fetchAddressList();
		System.out.println(address);
	
	}
	
	@Test
	@Order(2)
	@DisplayName("getbyID Address")
	void  getByIDTest() {
		Address address = service.fetchAddressById(1L);
		System.out.println(address);
	}
	
	@Test
	@Order(3)
	@DisplayName("update address")
	void updateTest() {
		Address address = service.fetchAddressById(1L);
		address.setBuildingName("SeaView Palace");
		address.setCity("Mumbai");
		repository.save(address);
		System.out.println("Updated new details to Address");
	}
	
	
	@Test
	@Order(4)
	@DisplayName("delete(ID) address")
	void deleteByIdTest() {
		service.deleteAddressById(2L);
	
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
		service.saveAddress(address);
	}
	
}
	

