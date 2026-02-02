package com.totok.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.totok.spring_boot_rest.model.JobPost;
import com.totok.spring_boot_rest.service.JobService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
	
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return jobService.GetAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return jobService.GetJob(postId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		jobService.AddJob(jobPost);
		return jobService.GetJob(jobPost.getPostId());
	}
}
