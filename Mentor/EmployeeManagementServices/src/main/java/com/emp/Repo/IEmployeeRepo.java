package com.emp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.Entity.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByUserid(Integer userid);

}
