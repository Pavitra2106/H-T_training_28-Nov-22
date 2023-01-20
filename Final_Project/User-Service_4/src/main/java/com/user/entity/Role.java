package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.user.model.ERoles;
@Entity
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Enumerated(EnumType.STRING)
	private ERoles name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ERoles getName() {
		return name;
	}
	public void setName(ERoles name) {
		this.name = name;
	}
	
	public Role(Long id, ERoles name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
	}
	
}