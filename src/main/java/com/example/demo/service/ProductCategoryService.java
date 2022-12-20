package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Productcategory;


public interface ProductCategoryService {
	public List<Productcategory> findAll();
	public Productcategory findById(int id);
	public void save(Productcategory productCategory);
	public void deleteById(int productCategoryId);
	public List<Productcategory> searchBy(String name);

}
