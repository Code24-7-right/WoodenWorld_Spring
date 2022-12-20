package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.persistence.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	private CartRepository cr;
	private ProductServiceImp psi;
	@Autowired
	public CartServiceImpl(CartRepository cr,ProductServiceImp psi) {
		this.cr = cr;
		this.psi = psi;
	}
	
	@Override
	@Transactional
	public List<Cart> findAll() {
		return cr.findAll();
	}

	@Override
	@Transactional
	public Cart save(Cart cart) {
		return cr.save(cart);
	}

	@Override
	@Transactional
	public void findCartItem(int pid,int uid,int position) {
		List<Cart> carts = cr.findAll();
		System.out.println(carts.toString());
		Cart c = new Cart();
		List<Cart> usercart = new ArrayList<Cart>();
		for(int i = 0; i < carts.size(); i++) {
			c = carts.get(i);
			if(uid == c.getUid()) {
				usercart.add(c);
			}
		}
		System.out.println(usercart.toString());
		c = usercart.get(position);
		System.out.println(c.toString());
		this.deleteCartItemById(c.getCid());
		/*carts = null;
		Product p = new Product();
		List<Product> cartProducts = new ArrayList<Product>();
		boolean flag = true;
		int i = 0;
		while(flag) {
			if(i < usercart.size()) {
				c = usercart.get(i);
				p = psi.findById(c.getPid());
				cartProducts.add(p);
				i=i+1;
			}
			if(i==usercart.size()) {
				flag = false;
			}
		}*/
	}
	
	@Override
	@Transactional
	public void deleteCartItemById(int cid) {
		cr.deleteById(cid);
	}
	
	@Override
	@Transactional
	public Cart findById(int cid) {
		return cr.findById(cid).get();
	}
	
	@Override
	@Transactional
	public List<Product> getCartItems(int uid) {
		List<Cart> carts = cr.findAll();
		Cart c = new Cart();
		List<Cart> usercart = new ArrayList<Cart>();
		for(int i = 0; i < carts.size(); i++) {
			c = carts.get(i);
			if(uid == c.getUid()) {
				usercart.add(c);
			}
		}
		carts = null;
		Product p = new Product();
		List<Product> cartProducts = new ArrayList<Product>();
		boolean flag = true;
		int i = 0;
		while(flag) {
			if(i < usercart.size()) {
				c = usercart.get(i);
				p = psi.findById(c.getPid());
				cartProducts.add(p);
				i=i+1;
			}
			if(i==usercart.size()) {
				flag = false;
			}
		}
		return cartProducts;
	}

	public boolean presentincart(Cart cart) {
		//System.out.println(cart.toString());
		List<Cart> carts = cr.findAll();
		//System.out.println(carts.toString());
		List<Product> cartItems =  this.getCartItems(cart.getUid());
		//System.out.println(cartItems.toString());
		Cart c = new Cart();
		int quantity;
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).getPid() == cart.getPid()) {
				//System.out.println("pid of product being added:"+cart.getPid());
				
				//for(int j = 0;j < carts.size();j++) {
					//if(cart.getUid() == carts.get(j).getUid()) {
						cart.setCid(carts.get(i).getCid());
						cart.setQuantity(carts.get(i).getQuantity());
						//c = carts.get(j);
						//System.out.println(c.toString());
						quantity = cart.getQuantity();
						cart.setQuantity(++quantity);
						cr.save(cart);
						//System.out.println(cr.findAll().toString());
						return true;
					//}
				//}
			}
		}
		return false;
	}
	
	public void reduceQuantity(Cart cart) {
		List<Cart> carts = cr.findAll();
		List<Product> cartItems =  this.getCartItems(cart.getUid());
		Cart c = new Cart();
		int quantity = 0;
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).getPid() == cart.getPid()) {
				//for(int j = 0;j < carts.size();j++) {
					//if(cart.getUid() == carts.get(j).getUid()) {
						cart.setCid(carts.get(i).getCid());
						cart.setQuantity(carts.get(i).getQuantity());
						
						//c = carts.get(j);
						quantity = cart.getQuantity();
						cart.setQuantity(--quantity);
						cr.save(cart);
						
					//}
				//}
			}
		}
	}

	public List<Cart> getUserCart(int uid) {
		List<Cart> carts = cr.findAll();
		List<Cart> usercart = new ArrayList<Cart>();
		for(int i = 0;i < carts.size(); i++) {
			if(carts.get(i).getUid() == uid) {
				usercart.add(carts.get(i));
			}
		}
		return usercart;
	}

	public Integer getTotalPrice(int uid) {
		int totalPrice = 0;
		List<Product> cartProducts = this.getCartItems(uid);
		List<Cart> usercart = this.getUserCart(uid);
		for(int i = 0; i < cartProducts.size();i++) {
			totalPrice += cartProducts.get(i).getPprice() * usercart.get(i).getQuantity();
		}
		return totalPrice;
	}
}
