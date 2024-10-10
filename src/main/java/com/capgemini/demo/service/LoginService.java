package com.capgemini.demo.service;

import com.capgemini.demo.entity.LoginDetails;

public interface LoginService {
	
	LoginDetails saveLogin(LoginDetails login);

	LoginDetails validateLogin(Long userID, String password);

	void deleteUserById(Long userID);

}
