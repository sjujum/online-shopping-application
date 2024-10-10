package com.capgemini.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="customers")
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_sequence",
		sequenceName = "customer_sequence",
		allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator = "customer_sequence")
	private Long customerID;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	@Builder.Default
	private String status="active";
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="addressID", referencedColumnName="addressID")
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
	private Address address;
	
}
