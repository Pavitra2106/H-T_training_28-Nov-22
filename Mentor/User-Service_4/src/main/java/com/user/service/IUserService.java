package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.Employee;
import com.user.entity.Jobs;
import com.user.entity.User;

public interface IUserService {
	
	//signin
	public User getUserByName(String username);
	
	//signup
	public User signup(User newUser);
	
	//delete user
	public void deleteUserDetail(Long id);
	
	// user by id
	public Optional<User> getusersbyid(Long id);
	
	//update user
	public User updateUserDetail(User user, Long id);
	
	//update userrole
	public User updateUserRole(String role, Long id);
	
	//Register user(view users)
	public List<User> getAllUsers();
	
	public Boolean updateJobAndSalary(Jobs jobs, Long userid);

}