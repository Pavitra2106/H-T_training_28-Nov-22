package com.jobs.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jobs.entity.Jobs;
import com.jobs.entity.Status;
import com.jobs.exception.ResourceNotFoundExceptionHandler;
import com.jobs.repo.JobsRepo;
import com.jobs.service.IJobsService;


@Configuration
@EnableScheduling
public class StatusUpdateJob {
	@Autowired
	private IJobsService iJobsService;
	
	@Autowired
	private JobsRepo jobsRepo;
	
	@Scheduled(cron="0/60 * * * * *")
	public void jobupdatestatus() {
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~Hello");
		List<Jobs> alljobs=iJobsService.getalljobs();  
		for(Jobs newjob:alljobs) {
			if(newjob.getStatus().equals(Status.inprogress)) {
				LocalDateTime tempDateTime = LocalDateTime.from( newjob.getJobstarttime() );
				long Days = tempDateTime.until( LocalDateTime.now(), ChronoUnit.DAYS );
				if(Days >=1) {
					Jobs existingjobsmodule = jobsRepo.findById(newjob.getId()).orElseThrow(
							() -> new ResourceNotFoundExceptionHandler("Jobs", "id", newjob.getId()));
					existingjobsmodule.setStatus(Status.notstarted);
					existingjobsmodule.setJobstarttime(null);
					jobsRepo.save(existingjobsmodule);
					//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~Hello");
				    }
			    }
			}
			
		}
		
	}
