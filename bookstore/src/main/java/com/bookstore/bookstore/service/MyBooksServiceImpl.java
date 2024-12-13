package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.MyBooks;
import com.bookstore.bookstore.repository.MyBooksRepository;

@Service
public class MyBooksServiceImpl implements MyBookService {
	
	@Autowired
	private MyBooksRepository myBooksRepository;
	
	

	public MyBooksServiceImpl(MyBooksRepository myBooksRepository) {
		super();
		this.myBooksRepository = myBooksRepository;
	}

	@Override
    public MyBooks saveMyBook(MyBooks book) {
        return myBooksRepository.save(book);
    }

	@Override
	public List<MyBooks> getAllMyBooks() {
		return myBooksRepository.findAll();
	}

}
