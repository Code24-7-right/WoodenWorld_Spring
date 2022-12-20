package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Userdetails;

public interface UserDetailsRepository extends JpaRepository<Userdetails, Integer> {

	default boolean findByUnameAndUpwd(String uname, String upwd) {
		List<Userdetails> users = findAll();
		Userdetails user = new Userdetails();
		for(int i = 0; i < users.size(); i++) {
			user = users.get(i);
			if(uname.equals(user.getUname()) && upwd.equals(user.getUpwd())) {
				return true;
			}
		}
		return false;
	}

}
