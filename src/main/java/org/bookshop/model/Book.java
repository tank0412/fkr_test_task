package org.bookshop.model;


import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "type")
    private BookType bookType;
    private BigDecimal price;
    private BigDecimal originalPrice;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orders;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public enum BookType {
        BOOK ("Книга"), JOURNAL ("Журнал");

        BookType(String type) {
            this.type = type;
        }
        private final String type;

        @JsonValue
        public String getType() {
            return type;
        }
    }
}
