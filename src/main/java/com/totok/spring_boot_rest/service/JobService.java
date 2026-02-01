package com.totok.spring_boot_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totok.spring_boot_rest.model.JobPost;
import com.totok.spring_boot_rest.repo.JobRepo;

@Service
public class JobService {
	
    @Autowired
    public JobRepo repo;
	
	public void AddJob(JobPost jobPost) {
		repo.addJob(jobPost);
	}
	
	public List<JobPost> GetAllJobs() {
		
		return repo.getAllJobs();
	}
	
	public JobPost GetJob(int postId) {
		return repo.getJob(postId);
	}

}
