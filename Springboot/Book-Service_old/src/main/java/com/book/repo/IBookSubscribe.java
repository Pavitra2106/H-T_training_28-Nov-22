package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.entity.BookSubscribe;

@Repository
public interface IBookSubscribe  extends JpaRepository<BookSubscribe, Integer>{


}
