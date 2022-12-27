package com.book.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookSubscribe {
	
	private Integer userid;
	private Integer bookid ;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Subscribeid;
	private LocalDateTime dateofSubscription;
	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}



	public Integer getSubscribeid() {
		return Subscribeid;
	}



	public void setSubscribeid(Integer subscribeid) {
		Subscribeid = subscribeid;
	}



	public LocalDateTime getDateofSubscription() {
		return dateofSubscription;
	}



	public void setDateofSubscription(LocalDateTime dateofSubscription) {
		this.dateofSubscription = dateofSubscription;
	}



	public BookSubscribe(Integer userid, Integer bookid, Integer subscribeid, LocalDateTime dateofSubscription) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		Subscribeid = subscribeid;
		this.dateofSubscription = dateofSubscription;
	}

	public BookSubscribe() {
		super();
	}

}
