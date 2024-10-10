package com.capgemini.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="logindetails")

public class LoginDetails {
	@Id
	private Long userID;
	private String password;
	private String roletype;
	
	public String getRoletype() {
		return roletype;
	}
}
