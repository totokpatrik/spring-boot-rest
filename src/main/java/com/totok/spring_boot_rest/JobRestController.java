package com.totok.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.totok.spring_boot_rest.model.JobPost;
import com.totok.spring_boot_rest.service.JobService;

@RestController
public class JobRestController {
	
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("jobPosts")
	@ResponseBody
	public List<JobPost> getAllJobs() {
		return jobService.GetAllJobs();
	}
	
	
}
