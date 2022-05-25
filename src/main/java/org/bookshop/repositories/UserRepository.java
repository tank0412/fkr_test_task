package org.bookshop.repositories;

import org.bookshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByDiscountGreaterThanEqual(Integer discount);
}
