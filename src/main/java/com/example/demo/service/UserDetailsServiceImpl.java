package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Userdetails;
import com.example.demo.persistence.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserDetailsRepository udr;
	
	@Autowired
	public UserDetailsServiceImpl(UserDetailsRepository udr) {
		this.udr = udr;
	}
	@Override
	@Transactional
	public List<Userdetails> findAll(){
		return udr.findAll();
	}
	@Override
	@Transactional
	public Userdetails save(Userdetails user) {
		return udr.save(user);
	}
}
