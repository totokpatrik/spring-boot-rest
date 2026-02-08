package com.totok.spring_boot_rest.repo;

import org.springframework.stereotype.Repository;

import com.totok.spring_boot_rest.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
