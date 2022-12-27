package com.digitalbooks.response;

import org.springframework.data.rest.core.config.Projection;

import com.digitalbooks.entity.ERole;
import com.digitalbooks.entity.Role;
import com.digitalbooks.entity.User;

@Projection(types = { Role.class, User.class })
public interface AuthorResponse {

	Integer getId();

	ERole getName();
	
	String getUsername();
	Integer getUserId();

}
