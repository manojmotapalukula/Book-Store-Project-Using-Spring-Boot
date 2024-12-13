package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.MyBooks;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.MyBookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;
  
    @Autowired
    private MyBookService myBookService;

    public BookController(BookService bookService, MyBookService myBookService) {
        super();
        this.bookService = bookService;
        this.myBookService = myBookService;
    }

    @GetMapping("/")
    public String home(){
        return "welcome";
    }
    //view books
    @GetMapping("/viewallbooks")
    public String viewAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "viewallbooks";
    }
    //add new book details
    @GetMapping("/addnewbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("addbookform", new Book());  // Add Book object for binding
        return "addnewbook";  
    }
    //add a book to books
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);  // Assuming you have a service method to save the book
        return "redirect:/viewallbooks";  // Redirect to the list of all books after saving
    }
    //goto my books
    @GetMapping("/mybooks")
    public String myBooks(Model model) {
        model.addAttribute("mybooks", myBookService.getAllMyBooks());
        return "mybooks";
    }
    //add a book to my book
    @GetMapping("/addtomybooks/{id}")
    public String getMyList(@PathVariable long id) {
        Book add = bookService.getBookById(id);
        MyBooks mybook = new MyBooks(add.getId(), add.getBookName(), add.getAuthor(), add.getPrice());
        myBookService.saveMyBook(mybook);
        return "redirect:/mybooks";
    }
    //edit book details
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable long id,Model model) {
    	model.addAttribute("book",bookService.getBookById(id) );
    	return "editbook";
    }
    //update book details
    @PostMapping("/updatebook/{id}")
    public String updateBook(@PathVariable long id, @ModelAttribute Book book) {
    	Book existing = bookService.getBookById(id);
    	existing.setBookName(book.getBookName());
    	existing.setAuthor(book.getAuthor());
    	existing.setPrice(book.getPrice());
        bookService.saveBook(existing);  // Assuming you have a service method to save the book
        return "redirect:/viewallbooks";  // Redirect to the list of all books after saving
    }
    

    //delete book record
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable long id) {
    	bookService.deleteBookById(id);
    	return "redirect:/viewallbooks";
    }
    
    //login 
    
    @GetMapping("/login")
    public String login() {
    	return "login.html";
    }
    
    //signup
    
    @GetMapping("/signup")
    public String signup() {
    	return "signup.html";
    }
}
