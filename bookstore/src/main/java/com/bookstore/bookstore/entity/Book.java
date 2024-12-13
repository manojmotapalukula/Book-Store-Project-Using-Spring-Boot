package com.bookstore.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    private String bookName;
    
    @Column
    private String author;
    
    @Column 
    private double price;

    

    public Book() {
    }

    public Book(Long id, String bookName, String author, double price) {
    	super();
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

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


