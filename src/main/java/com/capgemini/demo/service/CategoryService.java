package com.capgemini.demo.service;

import java.util.List;

import com.capgemini.demo.entity.Category;

public interface CategoryService {

	Category viewCategory(Integer categoryId);

	Category addCategory(Category category);

	List<Category> viewAllCategories();

	Category removeCategoryById(Integer categoryId);

	Category updateCategory(Category category);

}
