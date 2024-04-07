package com.nagarro.MongoDb.MongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
@Document(collection="Book")
public class Book {

	@Id
	private String id;
	private String bookName;
	private String authorName;
	
}
