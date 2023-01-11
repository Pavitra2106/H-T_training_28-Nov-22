package com.emp.Service;

import java.util.List;
import java.util.Optional;

import com.emp.Entity.Employee;

public interface IEmployeeService {
	
	public Integer saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();
	
	public Optional<Employee> getEmployeesById(Integer id);
	
	public void deleteEmployee(Integer id);
	
	public Employee updateEmployee(Employee employee ,Integer id );
	
	public void updateSalary(Employee employee ,Integer id );
}
