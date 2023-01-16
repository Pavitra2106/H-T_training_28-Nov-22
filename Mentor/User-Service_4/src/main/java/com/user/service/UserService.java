package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Employee;
import com.user.entity.Jobs;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundExceptionHandler;
import com.user.repo.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepo iUserRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User getUserByName(String username) {
		return iUserRepo.findByUsername(username);
	}

	@Override
	public User signup(User newUser) {
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		//User result = restTemplate.postForObject("http://EmployeeService/employee", newUser, User.class);
		return iUserRepo.save(newUser);
	}

	//delete user
	@Override
	public void deleteUserDetail(Long id) {
		iUserRepo.deleteById(id);
		
	}

	//update user
	@Override
	public User updateUserDetail(User user, Long id) {
		User existingUser = iUserRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundExceptionHandler("User", "id", id));
		
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setEmail(user.getEmail());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setRole(user.getRole());
		
		iUserRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public List<User> getAllUsers() {
		return iUserRepo.findAll();
	}

	public Boolean updateJobAndSalary(Jobs jobs, Long userid) {
//		
//		User existingUser = iUserRepo.findById(userid).orElseThrow(
//				() -> new ResourceNotFoundExceptionHandler("User", "userid", userid));
//		if(existingUser.getRole().toString().equals(jobs.getApplicablerole())) {
//			if(jobs.getStatus().equals("inprogress")) { 
//				//job eligibalty
//				
//				//
//				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
//				Employee employeedata= new Employee();
//				employeedata.setJob(jobs.getJobname());
//		        restTemplate.put(url, employeedata);  
//		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
//		        //restTemplate.put(urljob,jobs);
//			}
//			
//			 if(jobs.getStatus().equals("completed")) { 
//				System.out.println("~~~~~~~~~4~~~~~~~~~~~~~~~~~~~~~~~~");
//				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
//				Employee employeedata= new Employee();
//				employeedata.setSalary(jobs.getProfitvalue());
//		        restTemplate.put(url, employeedata);
//		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
//		        //restTemplate.put(urljob,jobs);
//			}
//			else if(jobs.getStatus().equals("aborted")) { 
//				System.out.println("~~~~~~~~~5~~~~~~~~~~~~~~~~~~~~~~~~");
//				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
//				Employee employeedata= new Employee();
//				employeedata.setJob(jobs.getJobname());
//		        restTemplate.put(url, employeedata);
//		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
//		        // restTemplate.put(urljob,jobs);
//			}
//			 String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
//		      restTemplate.put(urljob,jobs);
//		}
//		else
//		{
//			System.out.println("~~~~~~~~~6~~~~~~~~~~~~~~~~~~~~~~~~");
//			return false;
//		}
		return true;
	}

}