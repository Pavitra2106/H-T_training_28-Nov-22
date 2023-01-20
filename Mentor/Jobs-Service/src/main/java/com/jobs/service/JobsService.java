package com.jobs.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobs.exception.*;
import com.jobs.entity.Jobs;
import com.jobs.entity.Status;
import com.jobs.repo.JobsRepo;

@Service
public class JobsService implements IJobsService {
	
	@Autowired
	private JobsRepo jobsRepo;

	@Override
	public Long saveJobs(Jobs jobs) {
		jobs.setStatus(Status.valueOf("notstarted"));
		Jobs savedJobs = jobsRepo.save(jobs);
		return savedJobs.getId();
	}

	@Override
	public List<Jobs> getalljobs() {
		return jobsRepo.findAll() ;
	}
	@Override
	public List<Jobs> getallrolejobs(String role){
		
		return jobsRepo.findByApplicablerole(role) ;
	}
	
	//update jobs
	@Override
	public Jobs updateJobs(Jobs jobs, Long id) {
			Jobs existingjobsmodule = jobsRepo.findById(id).orElseThrow(
					() -> new ResourceNotFoundExceptionHandler("Jobs", "id", id));
			
			existingjobsmodule.setJobname(jobs.getJobname());
			existingjobsmodule.setStartingtime(jobs.getStartingtime());
			existingjobsmodule.setEndtime(jobs.getEndtime());
			existingjobsmodule.setProfitvalue(jobs.getProfitvalue());
			existingjobsmodule.setApplicablerole(jobs.getApplicablerole());
			existingjobsmodule.setStatus(jobs.getStatus());
			
			jobsRepo.save(existingjobsmodule);
			return existingjobsmodule;
		}

	@Override
	public void updateJobAndSalary(Jobs jobs) {
		Jobs existingjobsmodule = jobsRepo.findById(jobs.getId()).orElseThrow(
				() -> new ResourceNotFoundExceptionHandler("Jobs", "id", jobs.getId()));
		
		if(jobs.getStatus().equals(Status.inprogress)){
			
		existingjobsmodule.setJobstarttime(LocalDateTime.now());
		}
		if(jobs.getStatus().equals(Status.aborted)){
			LocalDateTime tempDateTime = LocalDateTime.from( existingjobsmodule.getJobstarttime() );
			long minutes = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MINUTES );
//			tempDateTime = tempDateTime.plusHours( minutes );
//			int timediff=tempDateTime.getMinute();
			if(minutes <=1) {
				//System.out.println("~~~~~~~~~5~~~~~~~~~~~~~~~~~~~~~~~~");
			jobs.setStatus(Status.notstarted);
			}
		}
		//System.out.println("~~~~~~~~~5~~~~~~~~~~~~~~~~~~~~~~~~ " +jobs.getStatus());
		existingjobsmodule.setStatus(jobs.getStatus());
		jobsRepo.save(existingjobsmodule);
	}

	@Override
	public Boolean jobtimeckeck(String currentjob, String newjob) {
		
		List<Jobs> job=jobsRepo.findByJobname(currentjob);
		LocalTime endtime = null;
		for(Jobs jobdata:job) {
			endtime=jobdata.getEndtime();
			break;
		}
		List<Jobs> job2=jobsRepo.findByJobname(newjob);
		LocalTime starttime = null;
		for(Jobs jobdata:job2) {
			starttime=jobdata.getStartingtime();
			break;
		}
		//System.out.println("~~~~~starttime~~~~ "+starttime);
		//System.out.println("~~~~~endtime~~~~ "+endtime);
		if (endtime.isAfter(starttime) ) {
			//System.out.println("~~~~~starttime~~~~ true ");
		return true;
		}
		return false;
	}
	
	
}
