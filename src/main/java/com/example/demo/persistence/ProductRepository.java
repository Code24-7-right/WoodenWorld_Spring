package com.example.demo.persistence;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Product;
@EnableJpaRepositories
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product>findByPnameContainingIgnoreCase( final String pname );

}
