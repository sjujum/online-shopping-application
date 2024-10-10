package com.capgemini.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.entity.Product;
import com.capgemini.demo.repository.CategoryRepository;
import com.capgemini.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Override
	@Transactional
	public Product addProduct(Product product) {
		Category category=categoryRepository.getById(product.getCategory().getCatId());
		product.setCategory(category);
		return repository.save(product);
	}

	@Override
	public Product viewProduct(Integer productId) {
		return repository.getProductById(productId);
				
	}
	
	@Override
	public List<Product> viewAllProducts() {
		return repository.findAll();
	}

	@Transactional
	@Override
	public Product removeProductById(Integer productId) {
		Product exists = repository.findById(productId).get();
		Product resultProduct=null;
		if(exists != null) {
			//repository.deleteById(productId);
			exists.setStatus("inactive");
			resultProduct=exists;
			repository.save(resultProduct);
		}
		return resultProduct;
	}

	@Override
	public Product updateProduct(Product product) {
		Product exists = repository.getProductById(product.getProductId());
		if(exists != null) {
			exists.setProductName(product.getProductName());
			exists.setPrice(product.getPrice());
			exists.setColor(product.getColor());
			exists.setDimension(product.getDimension());
			exists.setManufacturer(product.getManufacturer());
			exists.setQuantity(product.getQuantity());
			exists.setSpecification(product.getSpecification());
			exists.setCategory(product.getCategory());
			repository.save(exists);
			product = exists;
		}
		return product;
	}

	@Override
	public List<Product> viewProductsByCategory(String cname) {
		return repository.findByCategoryCategoryName(cname);

	}

}
