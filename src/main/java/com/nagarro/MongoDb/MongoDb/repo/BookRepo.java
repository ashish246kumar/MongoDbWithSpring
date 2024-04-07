package com.nagarro.MongoDb.MongoDb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nagarro.MongoDb.MongoDb.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer>{

}
