package com.BStore.bstore.service.impl;


import com.BStore.bstore.model.Book;
import com.BStore.bstore.repository.BookRepository;
import com.BStore.bstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BookServiceImplTest {

    private static final String AUTHOR = "Hose";
    private static final String TITLE = "El roja";
    private static final double PRICE = 10.0;
    private static final long ID = 1L;


    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUP() {
        when(bookRepository.save(any())).thenReturn(getBook());
    }


    @Test
    void getAllBooks() {
    }

    @Test
    void getBookById() {
        Book actualBook = bookService.saveBook(getBook());
        bookService.getBookById(actualBook.getId());

        assertEquals(ID, actualBook.getId());
    }

    @Test
    void saveBook() {
        Book actualBook = bookService.saveBook(getBook());

        assertEquals(AUTHOR, actualBook.getAuthor());
        assertEquals(TITLE, actualBook.getTitle());
        assertEquals(PRICE, actualBook.getPrice());
        assertEquals(ID, actualBook.getId());
    }

    @Test
    void updateBook() {
        Book actualBook = bookService.saveBook(getBook());
//vozmojno nujen entity in memory ?      Method threw 'jakarta.persistence.EntityNotFoundException' exception.
        bookService.updateBook(1L, actualBook).setAuthor("Fidel");
        bookService.updateBook(1L, actualBook).setTitle("La gato es bueno");
        bookService.updateBook(1L, actualBook).setPrice(15.00);

        assertEquals("Fidel", actualBook.getAuthor());
    }

    @Test
    void deleteBook() {
    }

    @Test
    void getPaginatedAndSortedBooks() {
    }


    private Book getBook() {
        return Book.builder()
                .id(ID)
                .author(AUTHOR)
                .title(TITLE)
                .price(PRICE)
                .build();
    }
}