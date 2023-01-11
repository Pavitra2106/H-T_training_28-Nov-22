package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.user.entity.User;
import com.user.repo.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepo iUserRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	

	@Override
	public User getUserByName(String username) {
		return iUserRepo.findByUsername(username);
	}

	@Override
	public User signup(User newUser) {
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		return iUserRepo.save(newUser);
	}

}
