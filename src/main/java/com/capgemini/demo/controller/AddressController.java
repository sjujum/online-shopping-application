package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.service.AddressService;

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

@RestController
@RequestMapping("/customer/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping("/save")
	public Address saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}
	
	@GetMapping("/get")
	public List<Address> fetchCustomerList(){
		return service.fetchAddressList();
	}
	
	@GetMapping("/get/{addressID}")
	public ResponseEntity<Address> fetchAddressById(@PathVariable("addressID") Long addressID) {
		Address address = service.fetchAddressById(addressID);
		return new ResponseEntity<Address>(address,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{addressID}")
	public String deleteAddressById(@PathVariable("addressID")Long addressID) {
		service.deleteAddressById(addressID);
		return "Address Deleted successfully";
	}
	
	@PutMapping("/update/{addressID}")
	public Address updateAddress(@PathVariable("addressID") Long addressID, @RequestBody Address address) {
		return service.updateAddress(addressID, address);
	}

}
