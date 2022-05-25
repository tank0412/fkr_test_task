package org.bookshop.repositories;

import org.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book b JOIN book_author ba ON ba.book_id = b.id WHERE ba.author_id IN :author_id", nativeQuery = true)
    List<Book> findAllByAuthors(@Param("author_id") Set<Long> authorId);

}
