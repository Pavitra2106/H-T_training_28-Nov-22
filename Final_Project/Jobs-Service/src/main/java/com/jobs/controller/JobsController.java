package com.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobs.entity.Jobs;
import com.jobs.service.IJobsService;

@RestController
public class JobsController {
	
	@Autowired
	private IJobsService iJobsService;
	
	@PostMapping("/addjobs")
	public Long createJobs(@RequestBody Jobs jobs) {
		 // System.out.println("~~~~~~~~~~~~~~~~~~~~~~create~~~~~~~~~~~~~~~~~~~~~~~");
		Long id = iJobsService.saveJobs(jobs);  
		return id;
	}

	
	@GetMapping("/alljobs")
	public List<Jobs> getAllJobs() {
		return iJobsService.getalljobs();  
	}
	
	@GetMapping("/allrolejobs/{role}")
	public List<Jobs> getallrolejobs(@PathVariable("role") String role) {
		return iJobsService.getallrolejobs(role);  
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Jobs> updateJobs(@PathVariable("id") Long id, @RequestBody Jobs jobs) {
		return new ResponseEntity<Jobs>(iJobsService.updateJobs(jobs, id), HttpStatus.OK);
		
	}

	@PutMapping("/updatejobtimestatus")
	public void updateJobAndSalary(@RequestBody Jobs jobs){
		iJobsService.updateJobAndSalary(jobs);
	}
	

	@GetMapping("/jobtimeckeck/{currentjob}/{newjob}")
	public Boolean jobtimeckeck(@PathVariable("currentjob") String currentjob,@PathVariable("newjob") String newjob) {
		
		return iJobsService.jobtimeckeck(currentjob,newjob);  
	}
}
