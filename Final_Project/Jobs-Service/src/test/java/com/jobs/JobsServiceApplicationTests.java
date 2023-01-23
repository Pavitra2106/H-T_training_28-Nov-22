package com.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jobs.entity.Jobs;
import com.jobs.entity.Status;
import com.jobs.repo.JobsRepo;
import com.jobs.service.IJobsService;



@SpringBootTest
class JobsModuleApplicationTests {
	
	@Autowired
	private IJobsService iJobsService;
	
	@MockBean
	private JobsRepo jobsRepo;

	@Test
	void contextLoads() {
	}
		
	@Test
	public void saveJobsTest() { 
		Jobs jobs = new Jobs
				(Long.valueOf(1L),
				"job1",
				LocalTime.now(),
				LocalTime.now(),
				200,
				"user",
				Status.notstarted,LocalDateTime.now());
		when(this.jobsRepo.save(jobs)).thenReturn(jobs);
		assertNotEquals(jobs,iJobsService.saveJobs(jobs)); 
	}
	
	
	@Test
	public void getAllJobsTest() {
		Jobs jobs1 = new Jobs(Long.valueOf(1L),"job1",LocalTime.now(),LocalTime.now(),500,"user",Status.notstarted,LocalDateTime.now());
		Jobs jobs2 = new Jobs(Long.valueOf(2L),"job2",LocalTime.now(),LocalTime.now(),100,"user",Status.inprogress ,LocalDateTime.now());
		Jobs jobs3 = new Jobs(Long.valueOf(3L),"job3",LocalTime.now(),LocalTime.now(),400,"user",Status.completed,LocalDateTime.now());
		Jobs jobs4 = new Jobs(Long.valueOf(4L),"job4",LocalTime.now(),LocalTime.now(),200,"user",Status.notstarted,LocalDateTime.now());
		List<Jobs> listofjobs = List.of(jobs1,jobs2,jobs3,jobs4);
		when(this.jobsRepo.findAll()).thenReturn(listofjobs);
		assertEquals(4,iJobsService.getalljobs().size());
	}
	
	@Test
	public void getallrolejobsTest() {
		Jobs jobs1 = new Jobs(Long.valueOf(1L),"job1",LocalTime.now(),LocalTime.now(),500,"user",Status.notstarted,LocalDateTime.now());
		Jobs jobs2 = new Jobs(Long.valueOf(2L),"job2",LocalTime.now(),LocalTime.now(),100,"user",Status.inprogress ,LocalDateTime.now());
		Jobs jobs3 = new Jobs(Long.valueOf(3L),"job3",LocalTime.now(),LocalTime.now(),400,"user",Status.completed,LocalDateTime.now());
		Jobs jobs4 = new Jobs(Long.valueOf(4L),"job4",LocalTime.now(),LocalTime.now(),200,"user",Status.notstarted,LocalDateTime.now());
		List<Jobs> listofjobs = List.of(jobs1,jobs2,jobs3,jobs4);
		when(this.jobsRepo.findByApplicablerole("user")).thenReturn(listofjobs);
		assertEquals(4,iJobsService.getallrolejobs("user").size());
	}
	
	
	@Test
	public void updateJobTest() {
		Jobs jobs = new Jobs(Long.valueOf(1L),"job1",LocalTime.now(),LocalTime.now(),500,"user",Status.notstarted,LocalDateTime.now());
		when(this.jobsRepo.findById(1L)).thenReturn(Optional.of(jobs));
		assertEquals(1L, jobs.getId());
		when(this.jobsRepo.save(jobs)).thenReturn(jobs);
		assertEquals(jobs, iJobsService.updateJobs(jobs, jobs.getId()));
	}
	
//	@Test
//	public void jobtimeckeckTest() {
//		Jobs jobs1 = new Jobs(Long.valueOf(1L),"job1",LocalTime.now(),LocalTime.now(),Long.valueOf(500L),"user",Status.notstarted,LocalDateTime.now());
//		Jobs jobs2 = new Jobs(Long.valueOf(2L),"job2",LocalTime.now(),LocalTime.now(),Long.valueOf(100L),"user",Status.inprogress ,LocalDateTime.now());
//		assertEquals(4,iJobsService.jobtimeckeck("user").size());
	


}