package com.user.service;

import com.user.entity.User;

public interface IUserService {
	
	public User getUserByName(String username);
	
	public User signup(User newUser);

}
