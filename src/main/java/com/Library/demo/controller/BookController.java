package com.Library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.demo.api.BookApi;
import com.Library.demo.model.Book;
import com.Library.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController implements BookApi {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	@Override
	public ResponseEntity<Book> addBook(Book book) {
		return new ResponseEntity<>(bookService.add(book), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Book> updateBook(Long id, Book bookDetails) {
		 Book updatedBook =bookService.updateBook(id,bookDetails);
		return new ResponseEntity<>(updatedBook, HttpStatus.OK);
	}

	@GetMapping("/genres")
	@Override
	public ResponseEntity<List<String>> getGenres() {
		
		return new ResponseEntity<>(bookService.getGenres(),HttpStatus.OK);
	}

	@GetMapping("/genres/{genre}")
	@Override
	public ResponseEntity<List<Book>> getBooksByGenre(String genre) {
		return new ResponseEntity<>(bookService.getBooksByGenre(genre),HttpStatus.OK);
	}

}
