package com.book.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.entity.BookSubscribe;
import com.book.repo.IBookRepo;
import com.book.repo.IBookSubscribe;
import com.book.exception.ResourceNotFoundException;

@Service
public class BookServiceImpl  implements IBookService{

	@Autowired
	private IBookRepo bookRepo;
	@Autowired
	private  IBookSubscribe bookSubscribe;
	@Override
	public Integer saveBook(Book book) {
		Book savebook =bookRepo.save(book);
		return savebook.getBookid();
	}

	@Override
	public Book updateBook(Book book, Integer bookid) {
		Book existingBook = bookRepo.findById(bookid).orElseThrow(()
				-> new ResourceNotFoundException("Book","bookid",bookid));
		
		existingBook.setBookname(book.getBookname());
		existingBook.setTitle(book.getTitle());
		existingBook.setCategory(book.getCategory());
		existingBook.setPrice(book.getPrice());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setPublisherDate(book.getPublisherDate());
		existingBook.setChapters(book.getChapters());
		existingBook.setActive(book.getActive());
		bookRepo.save(existingBook);
		return existingBook;
	}
	
	@Override
	public Boolean updateBookStatus(Boolean active, Integer bookid) {
		Book existingBook = bookRepo.findById(bookid).orElseThrow(()
				-> new ResourceNotFoundException("Book","bookid",bookid));
		if(!existingBook.equals(null)) {
		if(active)
		existingBook.setActive(active);
		else
			existingBook.setActive(active);
		bookRepo.save(existingBook);
		return true;
		}
		return false;
	}
	

	@Override
	public Optional<Book> getBooksById(Integer id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id);
	}

	@Override
	public Integer readerSubscribeBook(Integer userid, Integer bookid) {
		Book existingBook = bookRepo.findById(bookid).orElseThrow(()
				-> new ResourceNotFoundException("Book","bookid",bookid));
		if(existingBook != null)
		{
			BookSubscribe bookSubscribeData =new BookSubscribe();
			bookSubscribeData.setBookid(bookid);
			bookSubscribeData.setUserid(userid);
			bookSubscribeData.setDateofSubscription(LocalDateTime.now());
			bookSubscribe.save(bookSubscribeData);
			return bookSubscribeData.getSubscribeid();
	     }
		return null;
	}

	@Override
	public List<Book> readerAllSubscribeBook(Integer userid) {
		List<BookSubscribe> allbooks= bookSubscribe.findAll();
		allbooks=allbooks.stream().filter(resource -> resource.getUserid().
				 equals(userid)).collect(Collectors.toList());
		List<Book> newbooklist = new ArrayList<>();
		Optional<Book> newlist= Optional.empty();
		for (int i=0;i<allbooks.size(); i++) {
		 newlist=bookRepo.findById(allbooks.get(i).getBookid());
		 newbooklist.add(newlist.get());
		}
		return newbooklist;
		
	}

	@Override
	public Optional<Book> subscribeByIdBook(Integer userid, Integer subscribeid) {
		BookSubscribe existingSubscribedId = bookSubscribe.findById(subscribeid).orElseThrow(()
				-> new ResourceNotFoundException("BookSubscribe","subscribeid",subscribeid));
		if(existingSubscribedId.getUserid().equals(userid))
		{
			return bookRepo.findById(existingSubscribedId.getBookid());
		}
		return null;
	}
	
	@Override
	public String readSubscribedBook(Integer userid, Integer subscribeid) {
		BookSubscribe existingSubscribedId = bookSubscribe.findById(subscribeid).orElseThrow(()
				-> new ResourceNotFoundException("BookSubscribe","subscribeid",subscribeid));
		if(existingSubscribedId.getUserid().equals(userid))
		{
			Book existingBook = bookRepo.findById(existingSubscribedId.getBookid()).orElseThrow(()
					-> new ResourceNotFoundException("Book","bookid",existingSubscribedId.getBookid()));
			if (!existingBook.getActive()) {
				return existingBook.getBookcontent();
			}
			else {
				return "Book Is Blocked by Author";
			}
		}
		return "Wrong Subscribe Id";
	}

	@Override
	public String deletesubcribedbook(Integer userid, Integer subscribeid) {
		BookSubscribe existingSubscribedId = bookSubscribe.findById(subscribeid).orElseThrow(()
				-> new ResourceNotFoundException("BookSubscribe","subscribeid",subscribeid));
		if(existingSubscribedId.getUserid().equals(userid))
		{
			LocalDateTime tempDateTime = LocalDateTime.from(existingSubscribedId.getDateofSubscription() );
			long days = tempDateTime.until( LocalDateTime.now(), ChronoUnit.DAYS );
          if(days>1) {
        	  return "Subscription can't be cancel";
          }
          else {
        	  return "Your Subscription is canceled";
          }
		}
		return "Wrong Subscribe Id";
	}
	
	public List<Book> getByRequest(String category, String title, String author, String price,
			String publisher) {


		List<Book> books = bookRepo.findByCategoryAndTitleAndAuthorIdAndPriceAndPublisherActive(category,
				title, price, publisher);

		if (books == null || books.isEmpty()) {
			return null;
		}
		return books;
	}


}