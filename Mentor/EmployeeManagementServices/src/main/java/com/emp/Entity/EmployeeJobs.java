package com.emp.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class EmployeeJobs {
	
	@Id
	private int id;
	@ManyToOne(targetEntity=Employee.class , cascade =CascadeType.ALL) 
	@JoinColumn(referencedColumnName = "userid")
	 @JsonIgnoreProperties("job")
	private Employee userid;
	//private Employee empid;
	private Long jobid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getUserid() {
		return userid;
	}
	public void setEmpid(Employee userid) {
		this.userid = userid;
	}
	public Long getJobid() {
		return jobid;
	}
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}
	public EmployeeJobs(int id, Employee userid, Long jobid) {
		super();
		this.id = id;
		this.userid = userid;
		this.jobid = jobid;
	}
	public EmployeeJobs() {
		super();
	}
	
}
