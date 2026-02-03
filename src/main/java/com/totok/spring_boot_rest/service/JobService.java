package com.totok.spring_boot_rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totok.spring_boot_rest.model.JobPost;
import com.totok.spring_boot_rest.repo.JobRepo;

@Service
public class JobService {
	
	// ArrayList to store JobPost objects
	List<JobPost> jobs = new ArrayList<JobPost>(Arrays.asList(

			new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

			new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
					List.of("HTML", "CSS", "JavaScript", "React")),

			new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
					List.of("Python", "Machine Learning", "Data Analysis")),

			new JobPost(4, "Network Engineer",
					"Design and implement computer networks for efficient data communication", 5,
					List.of("Networking", "Cisco", "Routing", "Switching")),

			new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
					List.of("iOS Development", "Android Development", "Mobile App"))));
	
    @Autowired
    public JobRepo repo;
	
	public void AddJob(JobPost jobPost) {
		repo.save(jobPost);
	}
	
	public List<JobPost> GetAllJobs() {
		
		return repo.findAll();
	}
	
	public JobPost GetJob(int postId) {
		return repo.findById(postId).orElse(new JobPost());
	}
	
	public void ModifyJob(JobPost jobPost) {
		repo.save(jobPost);
	}

	public void DeleteJob(int postId) {
		repo.delete(GetJob(postId));
	}

	public void load() {
		repo.saveAll(jobs);
	}

}
