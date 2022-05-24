package org.bookshop.repositories;

import org.bookshop.model.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Book save(Book book) {
        em.persist(book);
        em.flush();
        return book;
    }

    @Override
    public List findAllBooks() {
        return em.createQuery("SELECT * FROM BOOKS").getResultList();
    }
}
