package com.resource.entity;

public class Resource {

	private Long rId;
	private String email;
	private String resourceName;
	private String domain;
	
	private Long userID;

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Resource(Long rId, String email, String resourceName, String domain, Long userID) {
		super();
		this.rId = rId;
		this.email = email;
		this.resourceName = resourceName;
		this.domain = domain;
		this.userID = userID;
	}

	public Resource() {
		super();
	}
	
	
}
