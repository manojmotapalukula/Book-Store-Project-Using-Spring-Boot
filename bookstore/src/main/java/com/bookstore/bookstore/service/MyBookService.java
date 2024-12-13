package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.MyBooks;

public interface MyBookService {
	public MyBooks saveMyBook(MyBooks mybook);
	public List<MyBooks> getAllMyBooks();

}
