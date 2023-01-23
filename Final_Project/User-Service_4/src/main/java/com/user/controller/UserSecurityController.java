package com.user.controller;


import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Employee;
import com.user.entity.Jobs;
import com.user.entity.JwtRequest;
import com.user.entity.JwtResponse;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.model.ERoles;
import com.user.service.IUserService;
import com.user.service.UserDataService;
import com.user.service.UserService;
import com.user.utility.JWTUtility;
import com.user.utility.UserValidator;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserSecurityController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserValidator  userValidator;
	
	@Autowired
	private RestTemplate restTemplate;
	//signup
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		User usersignup=iUserService.signup(user);
		String url ="http://EMPLOYEE-SERVICE/Add";
		Employee employeedata= new Employee();
		employeedata.setEmail(usersignup.getEmail());
		employeedata.setFirstname(usersignup.getFirstname());
		employeedata.setLastname(usersignup.getLastname());
		employeedata.setUserid(usersignup.getId());
		Optional employee=this.restTemplate.postForObject(url, employeedata, Optional.class);
		return new ResponseEntity<>(usersignup, HttpStatus.OK);
	}
	//signin
	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID CREDENTIALS", e);
		}
		final UserDetails userDetails = userDataService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtUtility.generateToken(userDetails);
		User loggedUser = iUserService.getUserByName(jwtRequest.getUsername());
		String rolename=null;
		for (Role name :loggedUser.getRoles()) {
	    	  rolename=name.getName().toString();
	    	 break;
	     }
		return new ResponseEntity<>(new JwtResponse(token,loggedUser.getUsername(),loggedUser.getId(),rolename)
				,HttpStatus.OK);
	}
	  //delete user
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<User> deleteUser(@PathVariable Long id) {
	  ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.OK);
			try {
				 String url ="http://EMPLOYEE-SERVICE/delete/"+id;
				 this.restTemplate.delete(url);
				userService.deleteUserDetail(id);
				} catch(Exception e) {
					e.printStackTrace();
					responseEntity = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
				}
			return responseEntity;
		}
		
		//update user
		@GetMapping("/update/{id}/{firstname}/{lastname}/{email}")
		public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@PathVariable("firstname") String firstname,
				@PathVariable("lastname") String lastname,@PathVariable("email") String email) {
			 User userdata= new User();
			 userdata.setId(id);
			 userdata.setEmail(email);
			 userdata.setFirstname(firstname);
			 userdata.setLastname(lastname);
			
			String url ="http://EMPLOYEE-SERVICE/update/"+id;
			    Employee employeedata= new Employee();
				employeedata.setEmail(userdata.getEmail());
				employeedata.setFirstname(userdata.getFirstname());
				employeedata.setLastname(userdata.getLastname());
				this.restTemplate.put(url, userdata);
			return new ResponseEntity<User>(userService.updateUserDetail(userdata, id), HttpStatus.OK);
		}
		
		//update userrole
		@GetMapping("/update/userrole/{role}/{id}")
		public ResponseEntity<User> updateUser(@PathVariable("role") String role,@PathVariable("id") Long id) {
			return new ResponseEntity<User>(userService.updateUserRole(role, id), HttpStatus.OK);
		}
		

		//all users
		@GetMapping("/allusers")
		public List<User> getAllUsers() {
			return userService.getAllUsers();
		}
		//getbyidusers   --notused
		@GetMapping("/getusersbyid/{id}")
		public List<User> getusersbyid(@PathVariable Long id) {
			Optional<User> getIdData=userService.getusersbyid(id);
			List<User> newgetIdData =getIdData.stream().collect(Collectors.toList());
			 return newgetIdData;
		}
		
	  @GetMapping("/getemp/{id}")
	    public List<Employee> getEmployee(@PathVariable Long id){
		  String url ="http://EMPLOYEE-SERVICE/get/";
		  Optional<Employee> empdata=   this.restTemplate.getForObject(url+id,Optional.class);
		  List<Employee> newgetIdData =empdata.stream().collect(Collectors.toList());
				   return newgetIdData;
	    }
	    
	  @GetMapping("/getallemp")
	    public List<Employee> getEmployee(){
		  String url ="http://EMPLOYEE-SERVICE/getall/";
		  return  this.restTemplate.getForObject(url,List.class);
	    }
	
	
//jobs
//create jobs
		@PostMapping("/createjobs")
		public ResponseEntity<?> createJobs(@RequestBody Jobs jobs) {
			String url ="http://JOBS-SERVICE/addjobs";
			Long jobId=this.restTemplate.postForObject(url, jobs, Long.class);
			return new ResponseEntity<>(jobId, HttpStatus.OK);
		}
		
		@GetMapping("/available/jobs")
		public List<Jobs> getalljobs() {
			  String url ="http://JOBS-SERVICE/alljobs";
			  return this.restTemplate.getForObject(url,List.class);
		}
		
		@GetMapping("/available/jobs/{role}")
		public List<Jobs> getallrolejobs(@PathVariable("role") String role) {
			  String url ="http://JOBS-SERVICE/allrolejobs/"+role;
			  return this.restTemplate.getForObject(url,List.class);
		}
		
		@GetMapping("/updatejob/{id}/{jobname}/{startingtime}/{endtime}/{profitvalue}/{applicablerole}/{status}")
		public ResponseEntity<?> updateJobs(@PathVariable("id") Long id,@PathVariable("jobname") String jobname,
				@PathVariable("startingtime") String startingtime,@PathVariable("endtime") String endtime,
				@PathVariable("profitvalue") Integer profitvalue,
				@PathVariable("applicablerole") String applicablerole,@PathVariable("status") String status) {
			 
			Jobs jobs= new Jobs();
			 jobs.setJobname(jobname);
			 jobs.setStartingtime(LocalTime.parse(startingtime));
      		 jobs.setEndtime(LocalTime.parse(endtime));
			 jobs.setProfitvalue(profitvalue);
			 jobs.setApplicablerole(applicablerole);
			 jobs.setStatus(status);
			 
			String url ="http://JOBS-SERVICE/update/"+id;
			 try {
			 this.restTemplate.put(url, jobs);
			 }
			 catch (Exception e) {
				 
				 return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
			}
			 return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		@PutMapping("/updateJobAndSalary/user/{userid}/{jobstatus}")
		public ResponseEntity<?> updateJobAndSalary( @PathVariable("userid") Long userid ,@PathVariable("jobstatus") String jobstatus 
				,@RequestBody Jobs jobs){
			jobs.setStatus(jobstatus);
			//System.out.println("~~~~~~~~~updateJobAndSalary~~~~~~~~~~~~~"+userid+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+jobstatus);
			Boolean task=userService.updateJobAndSalary( jobs,  userid);
			if(task) {
				 return new ResponseEntity<>(task ,HttpStatus.OK);
			}
			 return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
		}

}
