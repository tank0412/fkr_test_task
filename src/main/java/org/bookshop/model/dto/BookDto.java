package org.bookshop.model.dto;


import org.bookshop.model.Author;
import org.bookshop.model.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookDto {

    public BookDto(Long id, Book.BookType bookType, Set<Author> authors) {
        this.id = id;
        this.bookType = bookType;
        this.authors = authors;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private Book.BookType bookType;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    Set<Author> authors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book.BookType getBookType() {
        return bookType;
    }

    public void setBookType(Book.BookType bookType) {
        this.bookType = bookType;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
