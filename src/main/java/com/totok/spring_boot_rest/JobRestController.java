package com.totok.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.totok.spring_boot_rest.model.JobPost;
import com.totok.spring_boot_rest.service.JobService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
	
	
	@Autowired
	private JobService jobService;
	
	@GetMapping(path="jobPosts", produces = {"application/json"})
	public List<JobPost> getAllJobs() throws Exception {
		return jobService.GetAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return jobService.GetJob(postId);
	}
	
	@PostMapping(path="jobPost", consumes = {"application/xml", "application/json"})
	public JobPost addJob(@RequestBody JobPost jobPost) {
		jobService.AddJob(jobPost);
		return jobService.GetJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost modifyJob(@RequestBody JobPost jobPost) {
		jobService.ModifyJob(jobPost);
		return jobService.GetJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable("postId") int postId) {
		jobService.DeleteJob(postId);
		return "Deleted";
	}
	
	@GetMapping("load")
	public String loadData() {
		jobService.load();	
		return "success";
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String postProfile) {
		return jobService.searchByKeyword(postProfile);
	}
}
