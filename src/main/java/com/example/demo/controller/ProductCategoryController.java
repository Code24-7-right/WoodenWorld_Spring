package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Productcategory;
import com.example.demo.service.ProductCategoryServiceImpl;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
	private ProductCategoryServiceImpl prodcatser;
	@Autowired
	public ProductCategoryController(ProductCategoryServiceImpl prodcatser) {
		this.prodcatser = prodcatser;
	}
	@GetMapping("/display")
	public List<Productcategory> findAllProuctCategories(){
		return prodcatser.findAll();
	}
	@GetMapping("/searchProductsInCategory/{pcid}")
	public List<Product> searchProductsForCategory(@PathVariable int pcid){
		List<Product> productsFound = prodcatser.searchProductsForCategory(pcid);
		return productsFound;
	}
	@GetMapping("/showcategory/{productId}")
	public Productcategory getCategory(@PathVariable int productId) {
		Productcategory productCategory = prodcatser.findById(productId);
		if(productCategory == null) {
			throw new RuntimeException("Product category not existed with this id:" + productId);
		}
		return productCategory;
	}
	@PostMapping("/addcategory")
	public List<Productcategory> addProductCategory(@RequestBody Productcategory productCategory) {
		productCategory.setPcid(0);
		prodcatser.save(productCategory);
		return prodcatser.findAll();
	}
	@PutMapping("/updatecategory")
	public Productcategory updateProductCategory(@RequestBody Productcategory productCategory) {
		prodcatser.save(productCategory);
		return productCategory;
	}
	@DeleteMapping("deletecategory/{productCategoryId}")
	public List<Productcategory> deleteProductCategory(@PathVariable int productCategoryId) {
		Productcategory productCategory = prodcatser.findById(productCategoryId);
		if(productCategory == null) {
			throw new RuntimeException("Product Cateogory not existed with id:" + productCategoryId);
		}
		prodcatser.deleteById(productCategoryId);
		return prodcatser.findAll();
	}
	@GetMapping("/searchbycategory/{name}")
	public List<Productcategory> search(@PathVariable String name){
		List<Productcategory> products = prodcatser.searchBy(name);
		return products;
	}
}
