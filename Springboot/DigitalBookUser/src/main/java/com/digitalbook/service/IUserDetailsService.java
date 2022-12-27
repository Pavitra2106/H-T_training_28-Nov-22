package com.digitalbook.service;

import com.digitalbook.entity.user.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserDetailsService {

	public UserDetails loadUserByUsername(String username);

	public String userSignUp(User user);

	public String userSignIn(User user);

	//public String userSignIn(String username ,String password);
	
	public String accessRightCheck(Integer userid);


}
