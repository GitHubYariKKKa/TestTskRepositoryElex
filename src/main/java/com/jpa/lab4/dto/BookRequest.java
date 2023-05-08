package com.jpa.lab4.dto;

import com.jpa.lab4.model.Book;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequest {
    private String title;
    private String Author;
    private String genre;
    private LocalDate releasedYear;

    public BookRequest(Book book){
        this.title = book.getTitle();
        this.Author = book.getAuthor();
        this.genre = book.getGenre();
        this.releasedYear = book.getReleasedAt();
    }

    public BookRequest(){}
}
