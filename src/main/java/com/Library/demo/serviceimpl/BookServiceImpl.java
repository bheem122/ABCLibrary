package com.Library.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.demo.exception.BookNotFoundException;
import com.Library.demo.model.Book;
import com.Library.demo.repository.BookRepository;
import com.Library.demo.service.BookService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book add(Book book) {
		String title = book.getTitle().trim().toLowerCase(); // Trim spaces and convert to lowercase
	    
	    // Check if a book with the given title already exists
	    Book existingBook = bookRepository.findByTitleIgnoreCase(title);
	    if (existingBook != null) {
	        throw new EntityNotFoundException("The book with title '" + book.getTitle() + "' already exists.");
	    }
	    
	    // If the title doesn't exist, save the book
	    return bookRepository.save(book);
	}

	@Override
	public List<String> getGenres() {
		return bookRepository.findDistinctGenres();
	}

	@Override
	public List<Book> getBooksByGenre(String genre) {
		
		return bookRepository.findByGenre(genre);
	}

	@Override
	public Book updateBook(Long id, Book bookDetails) {
		Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());

        return bookRepository.save(book);
	}

}
