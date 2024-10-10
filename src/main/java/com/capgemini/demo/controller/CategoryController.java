package com.capgemini.demo.controller;

import java.util.List;

import com.capgemini.demo.entity.Category;
import com.capgemini.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Integer categoryId) {
		Category category = service.viewCategory(categoryId);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PostMapping("/save") //, produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		Category saved = null;
		saved = service.addCategory(category);
		return new ResponseEntity<Category>(saved, HttpStatus.OK);
	}
	@GetMapping("/get/all")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categoryList = service.viewAllCategories();
		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable("categoryId")Integer categoryId) {
		Category category = service.removeCategoryById(categoryId);
		if(category==null) {
			return new ResponseEntity("Sorry! Products are not available!",HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(
			@RequestBody Category category){
		Category categories= service.updateCategory(category);
		
		return new ResponseEntity<Category>(categories, HttpStatus.OK);
	}
}