package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface IUserService {
	
	//signin
	public User getUserByName(String username);
	
	//signup
	public User signup(User newUser);
	
	//delete user
	public void deleteUserDetail(Long id);
	
	//update user
	User updateUserDetail(User user, Long id);
	
	//Register user(view users)
	public List<User> getAllUsers();
	
	

}