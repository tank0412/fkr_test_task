package org.bookshop.controller;

import org.bookshop.model.dto.UserDto;
import org.bookshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @return list of users which discount is more than 2 (hardcoded)
     */
    @GetMapping("/users")
    public List<UserDto> allUsers() {
        return userService.getAllUsersWhereDiscountMoreThan2();
    }
}
