package com.Library.demo.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.demo.model.Book;


public interface BookApi {

	public ResponseEntity<Book> addBook(@RequestBody Book book);

	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails);

	public ResponseEntity<List<String>> getGenres();

	public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre);

}
