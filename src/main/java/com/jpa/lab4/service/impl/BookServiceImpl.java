package com.jpa.lab4.service.impl;

import com.jpa.lab4.exceptions.EntityNotFoundException;
import com.jpa.lab4.exceptions.NullEntityReferenceException;
import com.jpa.lab4.model.Book;
import com.jpa.lab4.repository.BookRepository;
import com.jpa.lab4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public Book create(Book book) {
        if (book!=null){
            return bookRepository.save(book);
        }
        throw new NullEntityReferenceException("Book was not found!");
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(getBookById(id));
    }

    @Override
    public Book update(Book book) {
        if (book!=null){
            return bookRepository.save(book);
        }else return null;
    }

}
