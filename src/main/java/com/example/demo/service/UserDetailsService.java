package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Userdetails;

public interface UserDetailsService {
	public List<Userdetails> findAll();
	public Userdetails save(Userdetails user);
}
