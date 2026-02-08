package com.totok.spring_boot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.totok.spring_boot_rest.repo.UserRepo;
import com.totok.spring_boot_rest.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	
	
	public User saveuser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepo.save(user);
	}
}
