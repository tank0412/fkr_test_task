package org.bookshop.repositories;

import org.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthors_Id(@Param("author_id") Set<Long> authorId);

}
