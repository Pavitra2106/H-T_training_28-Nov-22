package com.digitalbooks.validator;

import com.digitalbooks.entity.Book;
import com.digitalbooks.exception.InvalidRequestException;

public class BookValidator {

	public static void validate(Book book) {

		if (book.getPrice() < 0) {
			throw new InvalidRequestException("Error : Price should not negative " + book.getPrice());
		}

		if (book.getTitle().trim().equals("") || book.getCategory().trim().equals("")
				|| book.getContent().trim().equals("") || book.getPublisher().trim().equals("")) {
			throw new InvalidRequestException("Error : should not allow only space charcter ");
		}
	}

}
