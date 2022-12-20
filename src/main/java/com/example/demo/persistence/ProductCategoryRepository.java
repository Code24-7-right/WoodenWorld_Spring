package com.example.demo.persistence;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Productcategory;

public interface ProductCategoryRepository extends JpaRepository<Productcategory, Integer> {

	List<Productcategory> findByPcname(String name);
	List<Productcategory> findByPcnameContainingIgnoreCase(String pcname);

}
