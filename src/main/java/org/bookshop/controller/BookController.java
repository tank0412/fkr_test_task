package org.bookshop.controller;

import org.bookshop.model.Book;
import org.bookshop.model.dto.BookDto;
import org.bookshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping("/")
    public String root() {
        return "IT WORKS";
    }

    @ResponseBody
    @GetMapping("/books")
    public List<BookDto> allBooks() {
        return bookService.getAllBooks();
    }

    @ResponseBody
    @GetMapping("/books_full")
    public List<Book> allBooksFull() {
        return bookService.getAllBooksFull();
    }
}
