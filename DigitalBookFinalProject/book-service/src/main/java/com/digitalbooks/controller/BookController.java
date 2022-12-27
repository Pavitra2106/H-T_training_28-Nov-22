package com.digitalbooks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entity.Book;
import com.digitalbooks.response.BookResponse;
import com.digitalbooks.response.MessageResponse;
import com.digitalbooks.response.SearchBookResponse;
import com.digitalbooks.service.BookService;
import com.digitalbooks.util.ConstantValueUtil;
import com.digitalbooks.validator.BookValidator;

@RestController
@RequestMapping("/api/book/")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("save")
	public ResponseEntity<Integer> createBook(@Valid @RequestBody Book book) {

		BookValidator.validate(book);
		Book result  = bookService.createBook(book);

		return ResponseEntity.status(HttpStatus.CREATED).body(result.getId());

	}

	@PutMapping("update")
	public ResponseEntity<?> updateBook(@Valid @RequestBody Book book) {

		BookValidator.validate(book);
		bookService.updateBook(book);

		return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Book updated successfully!"));

	}

	@PostMapping("/author/{authorId}/book/{bookId}")
	public ResponseEntity<?> blockBook(@PathVariable Integer authorId, @PathVariable Integer bookId,
			@RequestParam String block) {

		bookService.blockBook(authorId, bookId, block);

		return ResponseEntity.ok(new MessageResponse(
				"Book " + (ConstantValueUtil.BLOCK.equals(block) ? "blocked" : "unblocked") + " successfully!"));

	}

	@GetMapping("/author/{authorId}/book/{bookId}")
	public ResponseEntity<Book> getBooksByAuthorBookId(@PathVariable Integer authorId, @PathVariable Integer bookId) {

		
		Book book = bookService.getBookByAuthorBookId(authorId, bookId);

		return ResponseEntity.ok(book);

	}

	@GetMapping("search")
	public ResponseEntity<?> getByRequest(@RequestParam(required = false) String category,
			@RequestParam(required = false) String title, @RequestParam(required = false) Integer authorId,
			@RequestParam(required = false) Double price, @RequestParam(required = false) String publisher) {


		List<BookResponse> books = bookService.getByRequest(category, title, authorId, price, publisher);

		return ResponseEntity.ok(books);

	}

	@GetMapping("get-all/{authorId}")
	public ResponseEntity<?> getBooksByAuthor(@PathVariable Integer authorId) {


		List<Book> books = bookService.getBooksByAuthor(authorId);

		return ResponseEntity.ok(books);

	}

	@GetMapping("get-all/books")
	public ResponseEntity<?> getListBookRes() {


		SearchBookResponse books = bookService.getListBookRes();

		return ResponseEntity.ok(books);

	}

}
