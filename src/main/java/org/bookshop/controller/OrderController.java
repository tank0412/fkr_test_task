package org.bookshop.controller;

import org.bookshop.model.Order;
import org.bookshop.model.send.OrderSend;
import org.bookshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *
     * @param orderSend - consists of following fields:
     * bookId - id of book
     * amount - number of books which will be bought
     * login - login of user
     * pw - user password (not encrypted)
     *
     * @return created order
     */
    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> newOrder(@RequestBody OrderSend orderSend) {
        Order order = orderService.createNewOrder(orderSend.getBookId(), orderSend.getAmount(), orderSend.getLogin(), orderSend.getPw());
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
