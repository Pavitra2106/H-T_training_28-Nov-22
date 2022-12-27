package com.digitalbook.entity.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import com.digitalbook.entity.user.Book;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	@Transient
    private String passwordConfirm;
    private String roles;

//    List<Book>book = new ArrayList<>();
//   
//
//	public List<Book> getBook() {
//		return book;
//	}
//	public void setBook(List<Book> book) {
//		this.book = book;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}


	public User(Integer id, String firstName, String lastName, String emailId, String password,
			String passwordConfirm, String roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}
//	public User(Integer id, String username, String firstName, String lastName, String emailId, String password,
//			String passwordConfirm, String roles, List<Book> book) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//		this.password = password;
//		this.passwordConfirm = passwordConfirm;
//		this.roles = roles;
//		this.book = book;
//	}
	public User() {
		super();
	}
	
   
}