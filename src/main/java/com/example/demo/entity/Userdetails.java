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
@Table(name="Userdetails")
public class Userdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	@Column(name="uname")
	private String uname;
	@Column(name="uemail")
	private String uemail;
	@Column(name="uphoneno")
	private String uphoneno;
	@Column(name="upwd")
	private String upwd;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	@Column(name="post_code")
	private int post_code;
	
	@OneToMany(mappedBy="uid")
	private Set<Cart> carts;
	
	public Userdetails() {
		
	}

	public Userdetails(int uid, String uname, String uemail, String uphoneno, String upwd, String address, String city,
			String country, int post_code, Set<Cart> carts) {
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.uphoneno = uphoneno;
		this.upwd = upwd;
		this.address = address;
		this.city = city;
		this.country = country;
		this.post_code = post_code;
		this.carts = carts;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphoneno() {
		return uphoneno;
	}

	public void setUphoneno(String uphoneno) {
		this.uphoneno = uphoneno;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPost_code() {
		return post_code;
	}

	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Userdetails [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", uphoneno=" + uphoneno
				+ ", upwd=" + upwd + ", address=" + address + ", city=" + city + ", country=" + country + ", post_code="
				+ post_code + ", carts=" + carts + "]";
	}
}
