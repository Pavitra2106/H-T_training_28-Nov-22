package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Library;

@Repository
public interface ILibraryRep extends JpaRepository<Library, Integer>{

}
