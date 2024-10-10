package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository repository;
	
	@Override
	public Category viewCategory(Integer categoryId) {
		return repository.findById(categoryId).get();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}

	@Override
	public List<Category> viewAllCategories() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Category removeCategoryById(Integer categoryId) {
	
		Category exists = repository.findById(categoryId).get();
		Category resultCategory=null;
		if(exists != null) {
			repository.deleteById(categoryId);
			resultCategory=exists;
		}
		return resultCategory;
	}
	

	@Override
	public Category updateCategory(Category category) {
		Category exists = repository.findById(category.getCatId()).get();
		if(exists != null) {
			exists.setCategoryName(category.getCategoryName());
			repository.save(exists);
			category = exists;
		}
		return category;
		
	}

}
