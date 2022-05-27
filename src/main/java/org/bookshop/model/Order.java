package org.bookshop.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
public class Order {
    public Order() {
    }

    public Order(Book book, Integer amount, BigDecimal orderTotal, User user) {
        this.book = book;
        this.amount = amount;
        this.orderTotal = orderTotal;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookId")
    private Book book;

    private Integer amount;

    private BigDecimal orderTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
