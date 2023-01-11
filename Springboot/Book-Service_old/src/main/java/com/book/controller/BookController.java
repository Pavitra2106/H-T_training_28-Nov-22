package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.IBookService;



@RestController
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	 @GetMapping("/{id}")
	    public Integer authenticateUser1(@PathVariable Integer id){
	     
	        return id;
	    }
	
	//create book ------------------W
 @PostMapping("/addnewbook")
 Integer createBook(@RequestBody Book book) {
	 Integer id = bookService.saveBook(book);
		
		return id;
   }
 
 //update a book ----------------
	@PutMapping("/updatebook/{bookid}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookid") Integer bookid ,@RequestBody Book book){
	
		try {
				bookService.updateBook(book, bookid);
		}catch(Exception e) {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
				return new ResponseEntity<Book>(HttpStatus.OK);
	}
	
	//can block and unblock a book------------
	@PatchMapping("updatestatus/{bookid}")
	public Boolean updateBookBorrowedStatus(@PathVariable("bookid") Integer bookid ,@RequestBody Book book ){
		Boolean bookstatus=book.getActive();
		return bookService.updateBookStatus(bookstatus, bookid);
		
	}
	
	@GetMapping("search")
	public ResponseEntity<?> getByRequest(@RequestParam(required = false) String category,
			@RequestParam(required = false) String title, @RequestParam(required = false) String author,
			@RequestParam(required = false) String price, @RequestParam(required = false) String publisher) {


		List<Book> books = bookService.getByRequest(category, title, author, price, publisher);

		return ResponseEntity.ok(books);

	}

	//--reader
	@PostMapping("/booksubcribtion/{userid}")
    public Integer readerSubscribeBook(@PathVariable("userid") Integer userid,@RequestBody Book book ){
		Integer bookid=book.getBookid();
		return bookService.readerSubscribeBook(userid,bookid);
				
	}
	
	@GetMapping("/allsubcribtionbooks/{userid}/read")
    public List<Book> readerAllSubscribeBook(@PathVariable("userid") Integer userid){
		return bookService.readerAllSubscribeBook(userid);
				
	}
	
	@GetMapping("/subcribedbook/{userid}/{subscribeid}")
    public Optional<Book> subscribeByIdBook(@PathVariable("userid") Integer userid,@PathVariable("subscribeid") Integer subscribeid){
		return bookService.subscribeByIdBook(userid,subscribeid);		
	}
	
	@GetMapping("/readsubcribedbook/{userid}/{subscribeid}")
    public String readSubscribedBook(@PathVariable("userid") Integer userid,@PathVariable("subscribeid") Integer subscribeid){
		return bookService.readSubscribedBook(userid,subscribeid);		
	}
	
	@DeleteMapping("/deletesubcribedbook/{userid}/{subscribeid}")
	public ResponseEntity<Book> deletesubscription(@PathVariable("userid") Integer userid,@PathVariable("subscribeid") Integer subscribeid){
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		 String errmeg=null;
		try{
		  errmeg= bookService.deletesubcribedbook(userid,subscribeid);
		
		  if (errmeg.equals("Subscription can't be cancel")) {
			  responseEntity =  new ResponseEntity<Book>(HttpStatus.NOT_ACCEPTABLE);
		  }
		}catch (Exception e) {
			e.printStackTrace();
			responseEntity =  new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return responseEntity ;
	}
}
