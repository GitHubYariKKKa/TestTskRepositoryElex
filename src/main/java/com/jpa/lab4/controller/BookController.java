package com.jpa.lab4.controller;

import com.jpa.lab4.dto.BookRequest;
import com.jpa.lab4.dto.BookResponse;
import com.jpa.lab4.model.Book;
import com.jpa.lab4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping()
    public ResponseEntity<BookRequest> create(@RequestBody BookRequest bookRequest){

        Book book = new Book(bookRequest.getTitle(),bookRequest.getAuthor());
        return new ResponseEntity<>(new BookRequest(bookService.create(book)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookRequest> update(@PathVariable(name = "id")int id, @RequestBody BookRequest bookRequest){
        Book bookToUpdate = new Book();
        bookToUpdate.setId(id);
        bookToUpdate.setAuthor(bookRequest.getAuthor());
        bookToUpdate.setTitle(bookRequest.getTitle());
        bookToUpdate.setGenre(bookRequest.getGenre());
        bookToUpdate.setReleasedAt(LocalDate.now());

        Book book = bookService.update(bookToUpdate);
        return new ResponseEntity<>(new BookRequest(book),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id){
        bookService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> read(@PathVariable(name = "id") int id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(new BookResponse(book),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> read(){
        List<BookResponse> books = bookService.getAll().stream()
                .map(BookResponse::new).toList();
        if (books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

