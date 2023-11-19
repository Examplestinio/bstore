package com.BStore.bstore.service.impl;

import com.BStore.bstore.model.Book;
import com.BStore.bstore.repository.BookRepository;
import com.BStore.bstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> getPaginatedAndSortedBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}