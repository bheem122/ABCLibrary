package com.Library.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Library.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("SELECT DISTINCT b.genre FROM Book b")
	List<String> findDistinctGenres();

	List<Book> findByGenre(String genre);

	Book findByTitleIgnoreCase(String title);


}
