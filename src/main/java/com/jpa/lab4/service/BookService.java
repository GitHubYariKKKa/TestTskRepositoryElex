package com.jpa.lab4.service;


import com.jpa.lab4.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);
    Book getBookById(int id);
    List<Book> getAll();
    void delete(int id);
    Book update(Book book);
}
