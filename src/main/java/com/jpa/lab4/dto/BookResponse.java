package com.jpa.lab4.dto;

import com.jpa.lab4.model.Book;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    private int id;
    private String title;
    private String Author;
    private LocalDate releasedAt;
    private String genre;

    public BookResponse(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.Author = book.getAuthor();
        this.releasedAt = book.getReleasedAt();
        this.genre = book.getGenre();
    }

    public BookResponse(){}
}
