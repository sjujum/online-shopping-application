package com.capgemini.demo.service;

import com.capgemini.demo.entity.LoginDetails;
import com.capgemini.demo.repository.LoginRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginServiceTests {
	@Autowired
	private LoginRepository repository;
	
	@Autowired
	LoginService service;
	
	@Test
	public void saveLogin() {
		LoginDetails loggedin = new LoginDetails();
                loggedin.setUserID((long) 7);
                loggedin.setPassword("sureshg@1503");
                loggedin.setRoletype("admin");
                
                service.saveLogin(loggedin);
     }
	
	@Test
	public void validateLogin() {
		
		service.validateLogin(1L,"suyog@1503");

		service.validateLogin(7L,"sureshg@1503");
		}
	
	@Test
	public void deleteUserById() {
		
		service.deleteUserById(1L);
	}

}


