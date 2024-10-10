package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;



public interface AddressService {

	Address saveAddress(Address address);

	List<Address> fetchAddressList();

	Address fetchAddressById(Long addressID);

	void deleteAddressById(Long addressID);

	Address updateAddress(Long addressID, Address address);

}
