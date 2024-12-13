package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.MyBooks;

public interface MyBooksRepository extends JpaRepository<MyBooks, Long> {

}
