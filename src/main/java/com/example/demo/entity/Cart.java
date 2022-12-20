package com.example.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	@Id
	@Column(name ="cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	@Column(name="uid")
	private int uid;
	@Column(name="pid")
	private int pid;
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(targetEntity=Product.class,fetch = FetchType.EAGER)
	@JoinColumn(name="pid",insertable = false, updatable = false)
	private Product products;
	
	@ManyToOne(targetEntity=Userdetails.class,fetch = FetchType.EAGER)
	@JoinColumn(name="uid",insertable = false, updatable = false)
	private Userdetails userdetails;
	
	public Cart() {
		
	}

	public Cart(int cid, int uid, int pid,int quantity) {
		this.cid = cid;
		this.uid = uid;
		this.pid = pid;
		this.quantity = quantity;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", uid=" + uid + ", pid=" + pid + ", quantity=" + quantity + "]";
	}
	
}
