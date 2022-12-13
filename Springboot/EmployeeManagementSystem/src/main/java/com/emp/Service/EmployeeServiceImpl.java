package com.emp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.Entity.Employee;
import com.emp.Repo.IEmployeeRepo;
import com.emp.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		Employee saveEmployee =employeeRepo .save(employee);
		return saveEmployee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeesById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee existingEmployee = employeeRepo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Employee","id",id));
		
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setePosition(employee.getePosition());
		existingEmployee.seteName(employee.geteName());
		existingEmployee.setSalary(employee.getSalary());
		employeeRepo.save(existingEmployee);
		return existingEmployee;
	}

	
}
