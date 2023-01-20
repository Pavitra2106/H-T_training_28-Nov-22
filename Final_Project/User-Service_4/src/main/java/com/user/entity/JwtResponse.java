package com.user.entity;

public class JwtResponse {
	
	private String jwtToken;
	private String username;
	private Long id;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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


	public JwtResponse(String jwtToken, String username, Long id, String role) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.id = id;
		this.role = role;
	}
	public JwtResponse() {
		super();
	}	
	
}
