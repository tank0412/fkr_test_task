package org.bookshop.services;

import org.bookshop.model.User;
import org.bookshop.model.dto.UserDto;
import org.bookshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final Integer DISCOUNT_DEFAULT = 2;

    public List<UserDto> getAllUsersWhereDiscountMoreThan2() {
        return userRepository.findByDiscountGreaterThanEqual(DISCOUNT_DEFAULT).stream().map(this::userToUserDto).collect(Collectors.toList());
    }

    private UserDto userToUserDto(User u) {
        return new UserDto(u.getId(),u.getLogin(), u.getDiscount());
    }
}
