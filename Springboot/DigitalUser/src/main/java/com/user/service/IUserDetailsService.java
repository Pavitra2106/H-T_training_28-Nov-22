package com.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.user.entity.User;

public interface IUserDetailsService {

	UserDetails loadUserByUsername(String username);

	String userSignUp(User user);

	String userSignIn(User user);

}
