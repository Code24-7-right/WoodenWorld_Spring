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
import com.example.demo.service.ProductServiceImp;

@RestController
@RequestMapping("/products")
public class ProductController {
	private ProductServiceImp prodser;
	@Autowired
	public ProductController(ProductServiceImp prodser) {
		this.prodser = prodser;
	}
	@GetMapping("/display")
	public List<Product> findAllProducts(){
		return prodser.findAll();
	}
	@GetMapping("/showproduct/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product product = prodser.findById(productId);
		if(product == null) {
			throw new RuntimeException("Product not existed with this id:" + productId);
		}
		return product;
	}
	@PostMapping("/addproduct")
	public List<Product> addProduct(@RequestBody Product product) {
		product.setPid(0);
		prodser.save(product);
		return prodser.findAll();
	}
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		prodser.save(product);
		return product;
	}
	@DeleteMapping("deleteproduct/{productId}")
	public List<Product> deleteProduct(@PathVariable int productId) {
		Product product = prodser.findById(productId);
		if(product == null) {
			throw new RuntimeException("Product not existed with id:" + productId);
		}
		prodser.deleteById(productId);
		return prodser.findAll();
	}
	@GetMapping("/searchproduct/{pname}")
	public List<Product> search(@PathVariable String pname)
	{
	List<Product> products=prodser.searchBy(pname);
	return products;
	}
}
