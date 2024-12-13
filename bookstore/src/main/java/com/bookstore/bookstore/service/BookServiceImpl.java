package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
    @Autowired
    private BookRepository bookRepository;
    

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save or update a book
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() { 
        return bookRepository.findAll();
    }

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}



    
}
