package com.Library.demo.service;

import java.util.List;

import com.Library.demo.model.Book;

public interface BookService {

	Book add(Book book);

	List<String> getGenres();

	List<Book> getBooksByGenre(String genre);

	Book updateBook(Long id, Book bookDetails);

}
