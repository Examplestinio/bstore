package com.BStore.bstore;

import com.BStore.bstore.model.Book;
import com.BStore.bstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetPaginatedAndSortedBooks(){

        //Given
        int pageSize = 2;
        int pageNumber = 0;
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        PageRequest pageable =PageRequest.of(pageNumber,pageSize,sort);

        //When
        Page<Book> result = bookService.getPaginatedAndSortedBooks(pageable);

        //Then
        assertEquals(pageSize,result.getSize());
        assertTrue(result.getTotalElements() > 0);
    }
}
