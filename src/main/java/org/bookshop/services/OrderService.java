package org.bookshop.services;

import org.bookshop.model.Book;
import org.bookshop.model.Order;
import org.bookshop.model.User;
import org.bookshop.repositories.BookRepository;
import org.bookshop.repositories.OrderRepository;
import org.bookshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Order createNewOrder(Long bookId, Integer amount, String login, char[] pw) {
        User user = userRepository.findByLoginAndPassword(login, pw);
        Book book = bookRepository.findOne(bookId);
        if (user != null && book != null) {
            BigDecimal price = book.getPrice();
            BigDecimal sum = price .multiply(BigDecimal.valueOf(amount));
            double userDiscount = user.getDiscount() / 100D;
            BigDecimal orderTotal = sum.subtract((sum.multiply(BigDecimal.valueOf(userDiscount))));
            orderTotal = orderTotal.setScale(2, RoundingMode.HALF_EVEN);
            Order order = new Order(book, amount, orderTotal, user);
            return orderRepository.saveAndFlush(order);
        } else {
            return null;
        }
    }

}
