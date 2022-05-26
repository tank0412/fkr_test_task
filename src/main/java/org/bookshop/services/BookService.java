package org.bookshop.services;

import org.bookshop.model.Book;
import org.bookshop.model.dto.BookDto;
import org.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(this::bookToBookDto).collect(Collectors.toList());
    }

    public List<BookDto> getAllBooksByAuthor(Set<Long> authorId) {
        return bookRepository.findByAuthors_Id(authorId).stream().map(this::bookToBookDto).collect(Collectors.toList());
    }

    public List<Book> getAllBooksFull() {
        return bookRepository.findAll();
    }

    private BookDto bookToBookDto(Book b) {
        return new BookDto(b.getId(), b.getBookType(), b.getAuthors());
    }
}
