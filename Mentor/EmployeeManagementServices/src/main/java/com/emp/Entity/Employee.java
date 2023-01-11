package com.emp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	private Long userid;
	private String firstname;
	private String lastname;
	private String email;
	private Integer salary;
	private String job;
	
	
	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Employee(Integer empid, Long userid, String firstname, String lastname, String email, Integer salary,
			String job) {
		super();
		this.empid = empid;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.salary = salary;
		this.job = job;
	}


	public Employee() {
		super();
	}
	
	
}
