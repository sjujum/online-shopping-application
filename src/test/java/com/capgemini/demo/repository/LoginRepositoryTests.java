package com.capgemini.demo.repository;

import com.capgemini.demo.entity.LoginDetails;
import com.capgemini.demo.service.LoginService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginRepositoryTests {
	@Autowired
	private LoginRepository repository;
	
	@Autowired
	LoginService service;
	
	@Test
	public void saveLogin() {
		LoginDetails loggedin = new LoginDetails();
                loggedin.setUserID((long) 1);
                loggedin.setPassword("suyog@1503");
                loggedin.setRoletype("admin");
        repository.save(loggedin);
	}
	
	@Test
	public void validateLogin() {
		repository.validateLogin((long) 1,"suyog@1503");
		repository.validateLogin((long) 2,"sujith@0007");
		repository.validateLogin((long) 4,"abvc@5698");
	}
	
	@Test
	public void deleteUserById() {
		repository.deleteById((long) 1);
	}

}

