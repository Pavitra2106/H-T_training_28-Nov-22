package com.digitalbooks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.request.Book;
import com.digitalbooks.request.BookSub;
import com.digitalbooks.response.BookResponse;
import com.digitalbooks.response.MessageResponse;
import com.digitalbooks.response.SearchBookResponse;
import com.digitalbooks.service.BookRestApiService;
import com.digitalbooks.validator.BookValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class BookController {


	@Autowired
	private BookRestApiService bookRestApiService;

	@PostMapping("author/{authorId}/books")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<Integer> createBook(@Valid @RequestBody Book book, @PathVariable Integer authorId)
			throws Exception {

		book.setAuthorId(authorId);
		BookValidator.validate(book);
		ResponseEntity<Integer> responseEntity = bookRestApiService.createBook(book);

		return responseEntity;

	}

	@PutMapping("author/{authorId}/books/{bookId}")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<MessageResponse> updateBook(@Valid @RequestBody Book book, @PathVariable Integer authorId,
			@PathVariable Integer bookId) throws Exception {

		book.setAuthorId(authorId);
		book.setId(bookId);
		BookValidator.validate(book);
		ResponseEntity<MessageResponse> responseEntity = bookRestApiService.updateBook(book);

		return responseEntity;

	}

	@PostMapping("author/{authorId}/books/{bookId}")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<MessageResponse> blockBook(@PathVariable Integer authorId, @PathVariable Integer bookId,
			@RequestParam String block) throws Exception {

		ResponseEntity<MessageResponse> responseEntity = bookRestApiService.blockBook(authorId, bookId, block);

		return responseEntity;

	}

	@GetMapping("author/{authorId}/books")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<List<BookResponse>> getBooksByAuthor(@PathVariable Integer authorId)
			throws JsonMappingException, JsonProcessingException {

		ResponseEntity<List<BookResponse>> responseEntity = bookRestApiService.getBooksByAuthor(authorId);

		return responseEntity;

	}

	@GetMapping("author/{authorId}/books/{bookId}")
	@PreAuthorize("hasRole('AUTHOR')")
	public ResponseEntity<Book> getBooksByAuthorAndBookId(@PathVariable Integer authorId, @PathVariable Integer bookId)
			throws Exception {

		ResponseEntity<Book> responseEntity = bookRestApiService.getBooksByAuthorAndBookId(authorId, bookId);

		return responseEntity;

	}

	@GetMapping("search")
	public ResponseEntity<List<BookResponse>> searchBooks(@RequestParam(required = false) String category,
			@RequestParam(required = false) @Nullable String title, @RequestParam(required = false) Integer author,
			@RequestParam(required = false) Double price, @RequestParam(required = false) String publisher)
			throws JsonMappingException, JsonProcessingException {

		ResponseEntity<List<BookResponse>> responseEntity = bookRestApiService.searchBook(category, title, author,
				price, publisher);

		return responseEntity;

	}

	@GetMapping("v2/search")
	public ResponseEntity<List<BookResponse>> searchBooksV2(@RequestParam(required = false) String category,
			@RequestParam(required = false) @Nullable String title, @RequestParam(required = false) String author,
			@RequestParam(required = false) Double price, @RequestParam(required = false) String publisher)
			throws JsonMappingException, JsonProcessingException {

		ResponseEntity<List<BookResponse>> responseEntity = bookRestApiService.searchBookV2(category, title, author,
				price, publisher);

		return responseEntity;

	}

	@PostMapping("readers/{bookId}/subscribe")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<Integer> subscribeBook(@Valid @RequestBody BookSub bookSub, @PathVariable Integer bookId)
			throws Exception {


		ResponseEntity<Integer> responseEntity = bookRestApiService.subscribeBook(bookSub);

		return responseEntity;

	}

	@GetMapping("readers/{emailId}/books")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<List<BookResponse>> getAllReaderBook(@PathVariable String emailId)
			throws JsonMappingException, JsonProcessingException {

		ResponseEntity<List<BookResponse>> responseEntity = bookRestApiService.getAllReaderBook(emailId);

		return responseEntity;

	}

	@GetMapping("readers/{emailId}/books/{subId}")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<Book> getReaderBook(@PathVariable String emailId, @PathVariable Integer subId)
			throws Exception {


		ResponseEntity<Book> responseEntity = bookRestApiService.getBookByReaderAndSubId(emailId, subId);

		return responseEntity;

	}

	@GetMapping("readers/{emailId}/books/{subId}/read")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<String> getReaderBookRead(@PathVariable String emailId, @PathVariable Integer subId)
			throws Exception {

		ResponseEntity<String> responseEntity = bookRestApiService.getContentByReaderAndSubId(emailId, subId);

		return responseEntity;

	}

	@PostMapping("readers/{emailId}/books/{subId}/cancel-subscription")
	@PreAuthorize("hasRole('READER')")
	public ResponseEntity<MessageResponse> cancelReaderBook(@PathVariable String emailId, @PathVariable Integer subId)
			throws Exception {

		ResponseEntity<MessageResponse> responseEntity = bookRestApiService.cancelByReaderAndSubId(emailId, subId);

		return responseEntity;

	}

	@GetMapping("get-all/books")
	public ResponseEntity<SearchBookResponse> getAllBook() throws Exception {

		ResponseEntity<SearchBookResponse> responseEntity = bookRestApiService.getAllBook();

		return responseEntity;

	}

}
