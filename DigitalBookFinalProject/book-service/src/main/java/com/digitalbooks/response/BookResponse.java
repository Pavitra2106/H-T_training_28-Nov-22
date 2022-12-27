package com.digitalbooks.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.BookSub;

@Projection(types = { Book.class, BookSub.class })
public interface BookResponse {
	
	Integer getBookId();

	String getLogo();

	String getTitle();

	Integer getAuthorId();

	String getPublisher();

	Double getPrice();

	LocalDateTime getCreatedDate();

	String getCategory();

	Integer getSubId();

	LocalDate getSubDate();

}
