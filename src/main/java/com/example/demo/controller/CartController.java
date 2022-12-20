package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.service.CartServiceImpl;

@RestController
@RequestMapping(path="/cart")
public class CartController {
	private CartServiceImpl csi;
	
	@Autowired
	public CartController(CartServiceImpl csi) {
		this.csi = csi;
	}
	@GetMapping("/totalPrice/{uid}")
	public Integer getTotalPrice(@PathVariable int uid) {
		return csi.getTotalPrice(uid);
	}
	@GetMapping("/cartLength/{uid}")
	public int noOfCartItems(@PathVariable int uid) {
		List <Product> cartItems = csi.getCartItems(uid);
		System.out.println(cartItems.size());
		return cartItems.size();
	}
	@GetMapping("/display")
	public List<Cart> findAllCartItems(){
		return csi.findAll();
	}	
	@GetMapping("/usercart/{uid}")
	public List<Cart> getUserCart(@PathVariable int uid){
		return csi.getUserCart(uid);
	}
	@GetMapping("/items/{uid}")
	public List<Product> getCartItems(@PathVariable int uid){
		List <Product> cartItems = csi.getCartItems(uid);
		return cartItems;
	}
	
	@PostMapping("/addtocart")
	public List<Cart> addToCart(@RequestBody Cart cart) {
		boolean found  = csi.presentincart(cart);
		if(!found) {
			System.out.println("Product being added is not is user cart");
			cart.setCid(0);
			cart.setQuantity(1);
			csi.save(cart);
		}
		return csi.findAll();
	}
	@PutMapping("/reduceQuantity")
	public List<Cart> reduceQuantity(@RequestBody Cart cart){
		csi.reduceQuantity(cart);
		return csi.findAll();
	}
	
	@DeleteMapping("/delete/{pid}/{uid}/{position}")
	public List<Product> deleteCartItem(@PathVariable int pid,@PathVariable int uid,@PathVariable int position){
		csi.findCartItem(pid, uid,position);
		/*Cart cartItem = csi.findById(cid);
		if(cartItem == null) {
			throw new RuntimeException("Cart Item does not exist with id:" + cid);
		}
		csi.deleteCartItem(cid);*/
		return csi.getCartItems(uid);
	}
}
