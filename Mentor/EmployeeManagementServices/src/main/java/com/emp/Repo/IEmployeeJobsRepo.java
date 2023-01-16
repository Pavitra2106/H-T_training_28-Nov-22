
package com.emp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.Entity.Employee;
import com.emp.Entity.EmployeeJobs;

@Repository
public interface IEmployeeJobsRepo extends JpaRepository<EmployeeJobs, Long>{
	
	//List<EmployeeJobs> findByEmpid(Integer empid);

}
