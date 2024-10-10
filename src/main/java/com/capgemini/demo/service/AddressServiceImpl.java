package com.capgemini.demo.service;

import java.util.List;
import java.util.Objects;

import com.capgemini.demo.entity.Address;
import com.capgemini.demo.entity.Customer;
import com.capgemini.demo.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository repository;
	
	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.save(address);
	}

	@Override
	public List<Address> fetchAddressList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Address fetchAddressById(Long addressID) {
		// TODO Auto-generated method stub
		return repository.findById(addressID).get();
	}

	@Override
	public void deleteAddressById(Long addressID) {
		// TODO Auto-generated method stub
		repository.deleteById(addressID);
	}

	@Override
	public Address updateAddress(Long addressID, Address address) {
	
		Address add = repository.findById(addressID).get();
		
		if(Objects.nonNull(address.getStreetNo()) && !"".equalsIgnoreCase(address.getStreetNo())) {
			add.setStreetNo(address.getStreetNo());
			
		}
		if(Objects.nonNull(address.getBuildingName()) && !"".equalsIgnoreCase(address.getBuildingName())) {
			add.setBuildingName(address.getBuildingName());
			
		}
		if(Objects.nonNull(address.getCity()) && !"".equalsIgnoreCase(address.getCity())) {
			add.setCity(address.getCity());
			
		}
		if(Objects.nonNull(address.getState()) && !"".equalsIgnoreCase(address.getState())) {
			add.setState(address.getState());
			
		}
		if(Objects.nonNull(address.getCountry()) && !"".equalsIgnoreCase(address.getCountry())) {
			add.setCountry(address.getCountry());
		}
		if(Objects.nonNull(address.getPincode()) && !"".equalsIgnoreCase(address.getPincode())) {
			add.setPincode(address.getPincode());
		}
		
		return repository.save(add);
		
	}


}
