package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.Book;

public interface BookService {
    public Book saveBook(Book book);
    public Book getBookById(long id);
    public List<Book> getAllBooks();
    public Book updateBook(Book book);
    public void deleteBookById(long id);

   
}
