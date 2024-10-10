package com.capgemini.demo.service;

import com.capgemini.demo.entity.LoginDetails;
import com.capgemini.demo.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repository;


	
	@Override
	public LoginDetails saveLogin(LoginDetails login) {
		return repository.save(login);
		

	}

	@Override
	public LoginDetails validateLogin(Long userID, String password) {
		return repository.validateLogin(userID,password);

	}

	@Override
	public void deleteUserById(Long userID) {
		repository.deleteById(userID);
		
		
	}

}
