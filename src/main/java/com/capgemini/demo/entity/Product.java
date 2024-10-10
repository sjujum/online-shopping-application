package com.capgemini.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {
	@Id
	@SequenceGenerator(
			name = "product_sequence",
			sequenceName = "product_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence")
	@Column(name = "product_id", columnDefinition = "int")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private double price;
	@Column(name="product_color")
	private String color;
	@Column(name="product_dim")
	private String dimension;
	@Column(name="product_specs")
	private String specification;
	@Column(name="product_manufacturer")
	private String manufacturer;
	@Column(name="product_quantity")
	private int quantity;
	
	@Column(name = "product_status")
	@Builder.Default
	private String status="active";
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Category category;

	

}
