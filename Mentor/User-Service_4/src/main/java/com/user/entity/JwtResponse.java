package com.user.entity;

public class JwtResponse {
	
	private String jwtToken;
	private String username;
	private String role;
	
	public JwtResponse(String jwtToken, String username, String role) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.role = role;
	}
	
	public JwtResponse() {
		super();
	}
	
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
