package com.jpa.lab4.repository;

import com.jpa.lab4.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book,Integer> {
    void deleteBookById(int id);
    List<Book> findByAuthor(String author);
}
