package com.user.entity;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Jobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String jobname;
	private LocalTime startingtime;
	private LocalTime endtime;
	private Long profitvalue;
	private String applicablerole;
	//@Enumerated(EnumType.STRING)
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public LocalTime getStartingtime() {
		return startingtime;
	}
	public void setStartingtime(LocalTime startingtime) {
		this.startingtime = startingtime;
	}
	public LocalTime getEndtime() {
		return endtime;
	}
	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}
	public Long getProfitvalue() {
		return profitvalue;
	}
	public void setProfitvalue(Long profitvalue) {
		this.profitvalue = profitvalue;
	}
	public String getApplicablerole() {
		return applicablerole;
	}
	public void setApplicablerole(String applicablerole) {
		this.applicablerole = applicablerole;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Jobs(Long id, String jobname, LocalTime startingtime, LocalTime endtime, Long profitvalue,
			String applicablerole, String status) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.startingtime = startingtime;
		this.endtime = endtime;
		this.profitvalue = profitvalue;
		this.applicablerole = applicablerole;
		this.status = status;
	}
	public Jobs() {
		super();
	}
	@Override
	public String toString() {
		return "Jobs [id=" + id + ", jobname=" + jobname + ", startingtime=" + startingtime + ", endtime=" + endtime
				+ ", profitvalue=" + profitvalue + ", applicablerole=" + applicablerole + ", status=" + status + "]";
	}

	
}