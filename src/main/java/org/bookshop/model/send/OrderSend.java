package org.bookshop.model.send;

public class OrderSend {
    public OrderSend() {

    }

    private Long bookId;
    private Integer amount;
    private String login;
    private char[] pw;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPw() {
        return pw;
    }

    public void setPw(char[] pw) {
        this.pw = pw;
    }
}
