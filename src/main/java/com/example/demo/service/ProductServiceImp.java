package com.example.demo.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.persistence.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	private ProductRepository prodrep;
	@Autowired
	public ProductServiceImp(ProductRepository prodrep) {
		this.prodrep = prodrep;
	}
	@Override
	@Transactional
	public List<Product> findAll() {
		return prodrep.findAll();
	}
	@Override
	@Transactional
	public Product findById(int id) {
		return prodrep.findById(id).get();
	}

	@Override
	@Transactional
	public void save(Product product) {
		prodrep.save(product);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		prodrep.deleteById(id);
	}
	@Override
	@Transactional
	public List<Product> searchBy(String pname) {
		List<Product> res = null;
		if(pname != null && pname.trim().length() > 0 ) {
			res = prodrep.findByPnameContainingIgnoreCase(pname);
		}
		else {
			res = findAll();
		}
		return res;
	}
}
