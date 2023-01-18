package com.emp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.Entity.Employee;
import com.emp.Repo.IEmployeeRepo;
import com.emp.exception.ResourceNotFoundException;

import jdk.jshell.spi.ExecutionControl.UserException;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeRepo employeeRepo;
	@Override
	public Integer saveEmployee(Employee employee) {
		Employee saveEmployee =employeeRepo .save(employee);
		return saveEmployee.getEmpid();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return  employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeesById(Long id) {
		// TODO Auto-generated method stub
		List<Employee> employee=employeeRepo.findByUserid(id);
		Integer empid = null;
		for(Employee employee2:employee) {
			empid=employee2.getEmpid();
			break;
		}
		Optional<Employee> emp= employeeRepo.findById(empid);
		
		return emp;
	}
	
	@Override
	public void deleteEmployee(Long id) {
		List<Employee> employee=employeeRepo.findByUserid(id);
		Integer empid = null;
		for(Employee employee2:employee) {
			empid=employee2.getEmpid();
			break;
		}
		employeeRepo.deleteById(empid);
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Integer empid = null;
		List<Employee> employeedata=employeeRepo.findByUserid(id);
		for(Employee employee2:employeedata) {
			empid=employee2.getEmpid();
			break;
		}
		final Integer empidnew= empid;
		Employee existingEmployee = employeeRepo.findById(empid).orElseThrow(()
				-> new ResourceNotFoundException("Employee","empid",empidnew));
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		employeeRepo.save(existingEmployee);
		return existingEmployee;
	}
	
	@Override
	public void updateJobSalary(Employee employee, Long id) {
		List<Employee> employeedata=employeeRepo.findByUserid(id);
		Integer empid = null;
		System.out.println("~~~~~~~~emp~~~~~~~~~~~~~~~~~~~~~~~ "+ employee.getSalary());
		for(Employee employee2:employeedata) {
			empid=employee2.getEmpid();
			break;
		}
		Employee existingEmployee = employeeRepo.findById(empid).orElseThrow(()
				-> new ResourceNotFoundException("Employee","id",id));
		if(!(employee.getJob()==null)&&!(employee.getJob()=="")) {
		existingEmployee.setJob(employee.getJob());
		}
		if(!(employee.getSalary()==null)) {
			Integer totalsaly=0;
			if(existingEmployee.getSalary() !=null) {
				totalsaly=existingEmployee.getSalary();
			}
			totalsaly=totalsaly+employee.getSalary();
			
		existingEmployee.setSalary(totalsaly);
		}
		employeeRepo.save(existingEmployee);
	}
	
	@Override
	public String jobcheck(Long id) {
		Integer empid = null;
		List<Employee> employeedata=employeeRepo.findByUserid(id);
		for(Employee employee2:employeedata) {
			empid=employee2.getEmpid();
			break;
		}
		final Integer empidnew= empid;
		Employee existingEmployee = employeeRepo.findById(empid).orElseThrow(()
				-> new ResourceNotFoundException("Employee","empid",empidnew));
		
		return existingEmployee.getJob();
	}
	
}
