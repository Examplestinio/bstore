package com.BStore.bstore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotEmpty
    private String title;

    @NotBlank
    private String author;

    @PositiveOrZero
    private double price;

    // constructors, getters, and setters

    public Book() {

    }
    public Book(String title, String author) {

        this.title = title;

        this.author = author;
    }

    public Long getId() {return id;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public double getPrice()  { return price; }

    public void setId(Long id) { this.id = id; }

    public void setTitle(String title) {this.title = title;}

    public void setAuthor(String author) {this.author = author;}

    public void setPrice(double price) {this.price = price;}


}