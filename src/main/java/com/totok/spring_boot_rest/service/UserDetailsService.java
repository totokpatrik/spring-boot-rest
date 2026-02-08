package com.totok.spring_boot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.totok.spring_boot_rest.repo.UserRepo;
import com.totok.spring_boot_rest.model.User;
import com.totok.spring_boot_rest.model.UserPrincipal;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		
		if (user == null) {
			System.out.println("User not found.");
			throw new UsernameNotFoundException("User not found.");
		}
		
		return new UserPrincipal(user);
	}

}
