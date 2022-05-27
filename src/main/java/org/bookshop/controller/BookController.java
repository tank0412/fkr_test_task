package org.bookshop.controller;

import org.bookshop.model.Book;
import org.bookshop.model.dto.BookDto;
import org.bookshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     *
     * @return "IT WORKS" to test if it works
     */
    @GetMapping("/")
    public String root() {
        return "IT WORKS";
    }

    /**
     *
     * @param authorId - will be used for filtration
     * @return List of all books (in dto) or list of books filtered by author
     */
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> allBooks(@RequestParam(value = "authorId", required = false) Set<Long> authorId) {
        if (authorId == null) {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(bookService.getAllBooksByAuthor(authorId), HttpStatus.OK);
        }
    }

    /**
     *
     * @return List of all books with all fields
     */
    @GetMapping("/books_full")
    public List<Book> allBooksFull() {
        return bookService.getAllBooksFull();
    }
}
