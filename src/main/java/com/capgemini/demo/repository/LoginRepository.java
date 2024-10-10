package com.capgemini.demo.repository;

import com.capgemini.demo.entity.LoginDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Long> {

	@Query(value = "SELECT * FROM logindetails ld WHERE ld.userID = ?1 and ld.password = ?2", 
	nativeQuery = true)
	
	LoginDetails validateLogin(Long userID,String password);

	
}
