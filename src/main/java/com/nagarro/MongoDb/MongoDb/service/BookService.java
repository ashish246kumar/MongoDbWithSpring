package com.nagarro.MongoDb.MongoDb.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.MongoDb.MongoDb.model.Book;
import com.nagarro.MongoDb.MongoDb.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepository;
	
	public void deleteBook( int id) {
		Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
        bookRepository.deleteById(id);
	}
	
	 public Book getBookById(int id) {
	        return bookRepository.findById(id)
	                             .orElseThrow(() -> new NoSuchElementException("Book not found"));
	    }
}
