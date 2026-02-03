package com.totok.spring_boot_rest.repo;
import org.springframework.stereotype.Repository;

import com.totok.spring_boot_rest.model.JobPost;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}
