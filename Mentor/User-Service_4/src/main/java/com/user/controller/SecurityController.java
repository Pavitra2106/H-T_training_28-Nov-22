package com.user.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Employee;
import com.user.entity.JwtRequest;
import com.user.entity.JwtResponse;
import com.user.entity.User;
import com.user.service.IUserService;
import com.user.service.UserDataService;
import com.user.utility.JWTUtility;

@RestController
public class SecurityController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private RestTemplate restTemplate;
	
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
		return new ResponseEntity<>(new JwtResponse(token,  loggedUser.getUsername() , loggedUser.getRole().toString()),
				HttpStatus.OK);
	}
	
	  @GetMapping("/getemp/{id}")
	    public Optional<Employee> getBook(@PathVariable Integer id){
		  String url ="http://EMPLOYEE-SERVICE/get/";
		  //Optional employee= 
				  return this.restTemplate.getForObject(url+id,Optional.class);
		 // return new ResponseEntity<>(usersignup, HttpStatus.OK);
	    }
	    
	  @GetMapping("/getallemp")
	    public List<Employee> getBook(){
		  String url ="http://EMPLOYEE-SERVICE/getall/";
		  return  this.restTemplate.getForObject(url,List.class);
	    }
	
	


}
