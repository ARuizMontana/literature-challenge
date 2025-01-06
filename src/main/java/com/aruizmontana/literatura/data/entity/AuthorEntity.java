package com.aruizmontana.literatura.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private int id;
    private String name;
    private int birthYear;
    private int deathYear;
    @ManyToOne
    @JoinColumn(name = "bookIdFk", insertable = false, updatable = false)
    private BookEntity book;

    public AuthorEntity() {}

    public AuthorEntity(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
    public AuthorEntity(String name, int birthYear, int deathYear, BookEntity book) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }
}
