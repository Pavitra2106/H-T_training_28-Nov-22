package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Library;
import com.library.exception.ResourceNotFoundException;
import com.library.repo.ILibraryRep;


@Service
public class LibraryServiceImpl implements ILibraryService{
	
	@Autowired
	private ILibraryRep iLibraryRep;
	
	//Save Book 
	@Override
	public Integer saveBook(Library library) {
		Library saveLibrary =iLibraryRep .save(library);
		return saveLibrary.getBookId();
	}
	//Get all list of Book 
	@Override
	public List<Library> getAllBooks(){
		return iLibraryRep.findAll();
	}
	//Get Book by book id
	@Override
	public Optional<Library> getBookById(Integer id) {
		// TODO Auto-generated method stub
		return iLibraryRep.findById(id);
	}

	//Deleting Book by book id
	@Override
	public void deleteBook(Integer id) {
		iLibraryRep.deleteById(id);
	}
	
	//Updating all the Book data by book id
	@Override
	public Library updateBook(Library library, Integer id) {
		Library existingBook = iLibraryRep.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Library","id",id));
		
		existingBook.setBookName(library.getBookName());
		existingBook.setBookAuthor(library.getBookAuthor());
		existingBook.setBookPrice(library.getBookPrice());
		existingBook.setBookGenre(library.getBookGenre());

		iLibraryRep.save(existingBook);
		return existingBook;
	}
	
	//Updating all the Book Borrowed Status by book id
	@Override
	public void updateBookBorrowedStatus(Library library, Integer id) {
		Library existingBook = iLibraryRep.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Library","id",id));
		if(library.getBorrowedStatus())
		existingBook.setBorrowedStatus(library.getBorrowedStatus());
		else
		existingBook.setBorrowedStatus(library.getBorrowedStatus());
		iLibraryRep.save(existingBook);
	}
	

}
