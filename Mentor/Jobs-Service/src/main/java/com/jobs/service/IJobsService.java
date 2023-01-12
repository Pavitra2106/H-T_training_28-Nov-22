package com.jobs.service;

import java.util.List;

import com.jobs.entity.Jobs;

public interface IJobsService {
	
	public Long saveJobs (Jobs jobs);
	
	public List<Jobs> getalljobs();
	
	//update job
	public Jobs updateJobs(Jobs jobs, Long id);

}
