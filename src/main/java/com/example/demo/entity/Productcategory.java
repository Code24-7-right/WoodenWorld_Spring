package com.example.demo.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Productcategory")
public class Productcategory {
	
	@Column(name="pcid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pcid;
	
	@Column(name="pcname")
	private String pcname;
	
	@OneToMany(mappedBy="pcid")
	private Set<Product> products;
	
	public Productcategory() {
		
	}

	public Productcategory(int pcid, String pcname, Set<Product> products) {
		this.pcid = pcid;
		this.pcname = pcname;
		this.products = products;
	}

	public int getPcid() {
		return pcid;
	}

	public void setPcid(int pcid) {
		this.pcid = pcid;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Productcategory [pcid=" + pcid + ", pcname=" + pcname + ", products=" + products + "]";
	}
}
