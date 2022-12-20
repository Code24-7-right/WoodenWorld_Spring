package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

public interface CartService {
	List<Cart> findAll();
	public Cart save(Cart cart);
	public void findCartItem(int pid,int uid,int position);
	public void deleteCartItemById(int cid);
	Cart findById(int cid);
	public List<Product> getCartItems(int uid);
}
