package com.BStore.bstore;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.BStore.bstore.model.Book;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookValidationTest {

    private final Validator validator = createValidator();

    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    public void testValidBook() {
        Book book = new Book();
        book.setAuthor("John Doe");
        book.setTitle("Jane Air");
        book.setPrice(11.50);

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertEquals(0, violations.size(), "Expected no validation errors");
    }


    @Test
    public void testNegativePrice(){
        Book book = new Book();
        book.setAuthor("John Doe");
        book.setTitle("Jane Air");
        book.setPrice(-5.60);

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertEquals(1, violations.size(), "Expected one validation error");
    }

    @Test
    public void testEmptyAuthor(){
        Book book = new Book();
        book.setTitle("King of the Hill");
        book.setPrice(1.10);

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertEquals(1, violations.size(), "Expected one validation error");
    }

    @Test
    public void testNullTitle(){
        Book book = new Book();
        book.setTitle(null);
        book.setAuthor("El Magelan");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertEquals(1, violations.size(), "Expected one validation error");
    }
}
