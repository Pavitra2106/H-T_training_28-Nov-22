package com.book.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;

@Repository
public interface IBookRepo  extends JpaRepository<Book, Integer>{

	@Query("SELECT *  FROM Book b WHERE "
			+ "(:category is null or b.category = :category) and (:title is null or b.title = :title) and "
			+ "(:author is null or b.author=:author) and (:price is null or b.price=:price) and "
			+ "(:publisher is null or b.publisher=:publisher)")
	List<Book> findByCategoryAndTitleAndAuthorAndPriceAndPublisherActive(@Param("category") String category,
			@Param("title") String title, @Param("author") String author, @Param("price") String price,
			@Param("publisher") String publisher);
}
