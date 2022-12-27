package com.digitalbooks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.request.LoginRequest;
import com.digitalbooks.request.SignupRequest;
import com.digitalbooks.response.JwtResponse;
import com.digitalbooks.response.MessageResponse;
import com.digitalbooks.service.AuthService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class AuthController {


	@Autowired
	private AuthService authService;

	@PostMapping("signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {


		ResponseEntity<JwtResponse> response = authService.authenticateUser(loginRequest);

		return response;
	}

	@PostMapping("signup")
	public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		ResponseEntity<MessageResponse> response = authService.registerUser(signUpRequest);

		return response;
	}

}
