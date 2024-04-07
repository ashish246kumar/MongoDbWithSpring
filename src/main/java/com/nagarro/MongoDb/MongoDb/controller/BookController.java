package com.nagarro.MongoDb.MongoDb.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.nagarro.MongoDb.MongoDb.model.Book;
import com.nagarro.MongoDb.MongoDb.repo.BookRepo;
import com.nagarro.MongoDb.MongoDb.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookRepo bookRepository;
	
	@Autowired
	private BookService bookSevice;
	
	
	@PostMapping("/addBook")
	public ResponseEntity<Book>  saveBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookRepository.save(book));
	}
	
	@GetMapping("/findAllBook")
	public List<Book>findAllBook(){
		return bookRepository.findAll();
	}
	@GetMapping("/findBook/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        try {
            Book book = bookSevice.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
	
		try {
			bookSevice.deleteBook(id);
			return ResponseEntity.ok("Book deleted Successfully");
			}
			catch(NoSuchElementException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			
			}
		
	}
	
	
}
