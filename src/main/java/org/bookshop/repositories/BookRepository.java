package org.bookshop.repositories;

import org.bookshop.model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAllBooks();
}
