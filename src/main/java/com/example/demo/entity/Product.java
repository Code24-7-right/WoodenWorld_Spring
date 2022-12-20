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
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private int pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name = "pimg")
	private String pimg;
	
	@Column(name = "pprice")
	private int pprice;
	
	@Column(name="pdesc")
	private String pdesc;
	
	@Column(name="pcid")
	private int pcid;
	
	@ManyToOne(targetEntity=Productcategory.class,fetch = FetchType.EAGER)
	@JoinColumn(name="pcid",insertable = false, updatable = false)
	private Productcategory pc;

	
	public Product() {
		
	}

	
	public Product(int pid, String pname, String pimg, int pprice, String pdesc, int pcid) {
		this.pid = pid;
		this.pname = pname;
		this.pimg = pimg;
		this.pprice = pprice;
		this.pdesc = pdesc;
		this.pcid = pcid;
	}

	
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPimg() {
		return pimg;
	}


	public void setPimg(String pimg) {
		this.pimg = pimg;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public String getPdesc() {
		return pdesc;
	}


	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}


	public int getPcid() {
		return pcid;
	}


	public void setPcid(int pcid) {
		this.pcid = pcid;
	}


	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pimg=" + pimg + ", pprice=" + pprice + ", pdesc=" + pdesc
				+ ", pcid=" + pcid + "]";
	}
	
}
