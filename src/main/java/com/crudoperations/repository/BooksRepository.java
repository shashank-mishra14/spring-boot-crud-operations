package com.crudoperations.repository;
import org.springframework.data.repository.CrudRepository;  

import com.crudoperations.model.Books;
//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer> {  
}