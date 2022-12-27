package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.Book;
import com.book.entity.BookSubscribe;

public interface IBookService {

	public Optional<Book> getBooksById(Integer id);
	
	public Integer saveBook(Book book);

	public Book updateBook(Book book, Integer bookid);
	
	public Boolean updateBookStatus(Boolean active ,Integer bookid );

	public Integer readerSubscribeBook(Integer userid, Integer bookid);

	List<Book> readerAllSubscribeBook(Integer userid);

	public Optional<Book> subscribeByIdBook(Integer userid, Integer subscribeid);

	public String readSubscribedBook(Integer userid, Integer subscribeid);

	public String deletesubcribedbook(Integer userid, Integer subscribeid);

}
