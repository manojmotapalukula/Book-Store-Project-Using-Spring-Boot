package com.bookstore.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybooks")
public class MyBooks {

    @Id
    @Column(name="book_id")
    private Long id;
    private String bookName;
    private String author;
    private double price;

    public MyBooks() {
    }

    public MyBooks(Long id, String bookName, String author, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void seId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

    

    
}
