package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Productcategory;
import com.example.demo.persistence.ProductCategoryRepository;
import com.example.demo.persistence.ProductRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	private ProductCategoryRepository prodcatrep;
	private ProductRepository pr;
	@Autowired
	public ProductCategoryServiceImpl(ProductCategoryRepository prodcatrep,ProductRepository pr) {
		this.prodcatrep = prodcatrep;
		this.pr = pr;
	}
	@Override
	@Transactional
	public List<Productcategory> findAll() {
		return prodcatrep.findAll();
	}
	
	@Override
	@Transactional
	public Productcategory findById(int id) {
		return prodcatrep.findById(id).get();
	}

	@Override
	@Transactional
	public void save(Productcategory productCategory) {
		prodcatrep.save(productCategory);
	}

	@Override
	@Transactional
	public void deleteById(int productCategoryId) {
		prodcatrep.deleteById(productCategoryId);
	}
	
	@Override
	@Transactional
	public List<Productcategory> searchBy(String name){
		List<Productcategory> res = null;
		if(name != null && name.trim().length() > 0) {
			res = prodcatrep.findByPcnameContainingIgnoreCase(name);
		}
		else {
			res = findAll();
		}
		return res;
	}
	public List<Product> searchProductsForCategory(int pcid) {
		List<Product> products = pr.findAll();
		List<Product> productsFound = new ArrayList<Product>();
		for(int i = 0 ; i < products.size();i++) {
			if(pcid == products.get(i).getPcid()) {
				productsFound.add(products.get(i));
			}
		}
		return productsFound;
	}
}
