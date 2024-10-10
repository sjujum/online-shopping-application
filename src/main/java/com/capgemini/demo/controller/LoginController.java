package com.capgemini.demo.controller;

import com.capgemini.demo.entity.LoginDetails;
import com.capgemini.demo.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController

public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/signup")
	public LoginDetails saveLogin(@RequestBody LoginDetails login) {
		
		return service.saveLogin(login);
	
	}
		
	@GetMapping("/signin/{userID}/{password}")
	public String signInWithCredentials(@PathVariable("userID") Long userID, @PathVariable("password") String password) {
			try {
				LoginDetails loggedUser = service.validateLogin(userID,password);
				if(loggedUser.getRoletype().equals("admin"))
					return "Admin Login Successful";
				if(loggedUser.getRoletype().equals("customer"))
					return "Customer Login Successful";
				return "Invalid Login";
			} catch (NullPointerException e) {
				return "Please check login credentials!";
			}
	}
	
	@DeleteMapping("/delete/{userID}")
	public String deleteUserById(@PathVariable("userID")Long userID) {
		service.deleteUserById(userID);
		return "User Deleted successfully";
	}
	
	@PostMapping("/logout")
	public String logout(@RequestBody LoginDetails login) {
		
		return "Logout Successful!";
	
	}

}
