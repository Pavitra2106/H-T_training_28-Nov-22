package com.digitalbooks.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.BookSub;
import com.digitalbooks.exception.InvalidRequestException;
import com.digitalbooks.exception.RequestNotFounException;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.BookSubRepository;
import com.digitalbooks.response.BookResponse;

@Service
public class BookSubService {

	@Autowired
	private BookSubRepository bookSubRepository;

	@Autowired
	private BookRepository bookRepository;

	public BookSub subscribeBook(BookSub bookSub) {


		Optional<Book> book = bookRepository.findById(bookSub.getBookId());
		if (book.isEmpty()) {
			throw new RequestNotFounException("Book not found ");
		}

		Optional<BookSub> existbookSub = bookSubRepository.findByBookIdAndReaderId(bookSub.getBookId(),
				bookSub.getReaderId());
		if (existbookSub.isPresent()) {
			throw new InvalidRequestException("Book already subscribed");
		}

		bookSub.setCreatedDate(LocalDate.now());

		BookSub result = bookSubRepository.save(bookSub);

		return result;

	}

	public List<BookResponse> getByReadeId(Integer readerId) {


		List<BookResponse> bookSubs = bookSubRepository.findByReaderId(readerId);

		if (bookSubs == null || bookSubs.isEmpty()) {
			throw new RequestNotFounException("Book not found ");
		}

		return bookSubs;

	}

	public BookResponse getByReadeIdAndSubId(Integer readerId, Integer subId) {

		Optional<BookResponse> bookSub = bookSubRepository.findByIdAndReader(subId, readerId);

		if (bookSub.isEmpty()) {
			throw new RequestNotFounException("Book not found ");
		}

		return bookSub.get();

	}

	public String contentByReaderAndSubId(Integer readerId, Integer subId) {

		Optional<BookSub> bookSub = bookSubRepository.findByIdAndReaderId(subId, readerId);
		if (bookSub.isEmpty()) {
			throw new RequestNotFounException("Content not found ");
		}

		Optional<Book> book = bookRepository.findById(bookSub.get().getBookId());
		if (book.isEmpty()) {
			throw new RequestNotFounException("Content not found ");
		}
		String content = book.get().getContent();

		return content;
	}

	public Book cancelSubByReaderAndSubId(Integer readerId, Integer subId) {


		Optional<BookSub> bookSub = bookSubRepository.findByIdAndReaderId(subId, readerId);

		if (bookSub.isEmpty()) {
			throw new RequestNotFounException("Book not found ");
		}

		Optional<Book> book = bookRepository.findById(bookSub.get().getBookId());

		if (book.isEmpty()) {
			throw new RequestNotFounException("Book not found ");
		}

		bookSub.get().setActive(false);
		bookSub.get().setUpdatedDate(LocalDate.now());
		bookSubRepository.save(bookSub.get());

		return book.get();
	}

}
