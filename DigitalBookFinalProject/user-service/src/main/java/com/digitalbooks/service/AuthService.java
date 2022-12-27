package com.digitalbooks.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.digitalbooks.entity.ERole;
import com.digitalbooks.entity.Role;
import com.digitalbooks.entity.User;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.request.LoginRequest;
import com.digitalbooks.request.SignupRequest;
import com.digitalbooks.response.JwtResponse;
import com.digitalbooks.response.MessageResponse;
import com.digitalbooks.security.jwt.JwtUtils;
import com.digitalbooks.security.services.UserDetailsImpl;

@Service
public class AuthService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}
	
	public ResponseEntity<MessageResponse> registerUser(SignupRequest signUpRequest) {

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Created new user's account

		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));

		if (signUpRequest.getRoles().equalsIgnoreCase("AUTHOR")) {
			System.out.println("AUTHORS : ");
			Role roles = roleRepository.findByName(ERole.ROLE_AUTHOR).get();
			user.setRoles(Collections.singleton(roles));
		} else if (signUpRequest.getRoles().equalsIgnoreCase("READER")) {
			System.out.println("READER : ");
			Role roles = roleRepository.findByName(ERole.ROLE_READER).get();
			user.setRoles(Collections.singleton(roles));
		} else {
			System.out.println("GUEST : ");
			Role roles = roleRepository.findByName(ERole.ROLE_GUEST).get();
			user.setRoles(Collections.singleton(roles));
		}

		userRepository.save(user);

		System.out.println("final or exit: " + user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
