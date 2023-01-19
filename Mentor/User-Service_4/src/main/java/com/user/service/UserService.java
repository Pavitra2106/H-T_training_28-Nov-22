package com.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Employee;
import com.user.entity.Jobs;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundExceptionHandler;
import com.user.model.ERoles;
import com.user.repo.IRoleRepo;
import com.user.repo.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepo iUserRepo;
	
	@Autowired
	private IRoleRepo iRoleRepo;
	
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
	
	public Optional<User> getusersbyid(Long id){
		
		return iUserRepo.findById(id);
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
		
//		Set<Role> roles = new HashSet<>();	 
//		 for (Role name : user.getRoles()) {
//			 String rolename=name.getName().toString();
//			if(rolename.equals("manager")) {
//				Role adminRole = iRoleRepo.findByName(ERoles.manager)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(adminRole);
//			}
//			else {
//			
//				Role userRole = iRoleRepo.findByName(ERoles.user)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(userRole);
//			}
//
//		}
//		existingUser.setRoles(roles);
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setEmail(user.getEmail());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());		
		iUserRepo.save(existingUser);
		return existingUser;
	}
	
	@Override
	public User updateUserRole(String role, Long id) {
		User existingUser = iUserRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundExceptionHandler("User", "id", id));
		
		Set<Role> roles = new HashSet<>();	 
//		 for (Role name : user.getRoles()) {
			 //String rolename=role;
			if(role.equals("manager")) {
				Role adminRole = iRoleRepo.findByName(ERoles.manager)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(adminRole);
			}
			else {
			
				Role userRole = iRoleRepo.findByName(ERoles.user)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			}

		//}
		existingUser.setRoles(roles);
		iUserRepo.save(existingUser);
		return existingUser;
	}
	@Override
	public List<User> getAllUsers() {
		return iUserRepo.findAll();
	}

	public Boolean updateJobAndSalary(Jobs jobs, Long userid) {
		
		User existingUser = iUserRepo.findById(userid).orElseThrow(
				() -> new ResourceNotFoundExceptionHandler("User", "userid", userid));
		     //Set<Role> role= existingUser.getRoles();
		String rolename=null;
		     for (Role name :existingUser.getRoles()) {
		    	  rolename=name.getName().toString();
		    	 break;
		     }
		   // System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~rolematch~~~~"+rolename+"~~~~"+jobs.getApplicablerole());
		if(rolename.equals(jobs.getApplicablerole())) {
			
			//System.out.println("~~~~~~~~~~~~rolematch~~~~ "+jobs.getStatus());
			if(jobs.getStatus().equals("inprogress")) { 
				//System.out.println("~~~~~~~~~~~~Status~~~~");
				//job eligibalty
				String url0 ="http://EMPLOYEE-SERVICE/jobckeck/"+userid;
		        String currentJob=restTemplate.getForObject(url0, String.class);  
		        if(currentJob!=null) {
		        	// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~currentJob~~~~"+currentJob);
		        String urljob ="http://JOBS-SERVICE/jobtimeckeck/"+currentJob+"/"+jobs.getJobname();
		        Boolean jobaccess=  restTemplate.getForObject(urljob,Boolean.class);
		       // System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~jobaccess~~~~"+jobaccess);
		        if(jobaccess) {
		        	return false;
		        }
		        }
		        
				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
				Employee employeedata= new Employee();
				employeedata.setJob(jobs.getJobname());
		        restTemplate.put(url, employeedata);  
		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
		        //restTemplate.put(urljob,jobs);
		        
			}
			
			 if(jobs.getStatus().equals("completed")) { 
				//System.out.println("~~~~~~~~~4~~~~~~~~~~~~~~~~~~~~~~~~");
				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
				Employee employeedata= new Employee();
				employeedata.setSalary(jobs.getProfitvalue());
		        restTemplate.put(url, employeedata);
		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
		        //restTemplate.put(urljob,jobs);
			}
			else if(jobs.getStatus().equals("aborted")) { 
				//System.out.println("~~~~~~~~~5~~~~~~~~~~~~~~~~~~~~~~~~");
				String url ="http://EMPLOYEE-SERVICE/updateJobSalary/"+userid;
				Employee employeedata= new Employee();
				employeedata.setJob(jobs.getJobname());
		        restTemplate.put(url, employeedata);
		       // String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
		        // restTemplate.put(urljob,jobs);
			}
			// System.out.println("~~~~~~~~~5~~~~~~~~~~~~~~~~~~~~~~~~");
			 String urljob ="http://JOBS-SERVICE/updatejobtimestatus";
		      restTemplate.put(urljob,jobs);
		}
		else
		{
			//System.out.println("~~~~~~~~~6~~~~~~~~~~~~~~~~~~~~~~~~");
			return false;
		}
		return true;
	}

}