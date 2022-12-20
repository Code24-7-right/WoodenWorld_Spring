package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Userdetails;
import com.example.demo.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(path="/userdetails")
public class UserDetailsController {
	private UserDetailsServiceImpl udsi;
	
	@Autowired
	public UserDetailsController(UserDetailsServiceImpl udsi) {
		this.udsi = udsi;
	}
	
	@GetMapping("/display")
	public List<Userdetails> findAllUsers(){
		return udsi.findAll();
	}
	
	@PostMapping("/adduser")
	public Userdetails addUserdetails(@RequestBody Userdetails user) {
		user.setUid(0);
		udsi.save(user);
		return user;
		
	}
}
