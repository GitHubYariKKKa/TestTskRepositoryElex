package com.jpa.lab4.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "createdat")
    private LocalDate releasedAt;

    @Column(name = "genre")
    private String genre;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.releasedAt = LocalDate.now();
    }
}
