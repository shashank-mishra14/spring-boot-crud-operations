package com.crudoperations.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.crudoperations.model.Books;
import com.crudoperations.service.BooksService;

//marks class as Controller
@RestController
public class BooksController {
    //autowired the booksService class
    @Autowired
    BooksService booksService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/books")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/books/{bookid}")
    private Books getBooks(@PathVariable ("bookid") int bookid){
        return booksService.getBooksById(bookid);
    }


    @DeleteMapping("/books/{bookid}")
    private void deleteBook(@PathVariable ("bookid") int bookid){
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books;
    }
}
