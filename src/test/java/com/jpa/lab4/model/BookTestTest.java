package com.jpa.lab4.model;

import com.jpa.lab4.repository.BookRepository;
import com.jpa.lab4.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTestTest {

    @Autowired
    BookService bookService;

    @Test
    void createBook() {
        Book book = new Book();
        book.setTitle("new Book");
        book.setAuthor("Davinchi");
        book.setGenre("Fantasy");
        book.setReleasedAt(LocalDate.now());
        bookService.create(book);
        assertNotEquals(0, book.getId());
    }

    @Test
    void BookRead(){
        Book book = bookService.getBookById(1);
        assertEquals("new Book", book.getTitle());
    }

    @Test
    void BookUpdate(){
        Book actual = bookService.getBookById(1);
        actual.setGenre("Horror");
        bookService.update(actual);

        Book expected = bookService.getBookById(1);
        assertEquals(expected.getGenre(), actual.getGenre());
    }
}