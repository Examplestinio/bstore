package com.BStore.bstore.service;

import com.BStore.bstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book saveBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    Page<Book> getPaginatedAndSortedBooks(Pageable pageable);
}
