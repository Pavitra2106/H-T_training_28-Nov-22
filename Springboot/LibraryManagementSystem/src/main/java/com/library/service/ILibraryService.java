package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Library;


public interface ILibraryService {
	
	Integer saveBook(Library library);

	public List<Library> getAllBooks();
	
	Optional<Library> getBookById(Integer id);
	
	public void deleteBook(Integer id);
	
	Library updateBook(Library library ,Integer id );
	
	public void updateBookBorrowedStatus(Library library ,Integer id );
	

}
