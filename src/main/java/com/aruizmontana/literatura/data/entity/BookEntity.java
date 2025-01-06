package com.aruizmontana.literatura.data.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private int id;
    private int isbn;
    private String title;
    private String author;
    private String languages;
    private int downloadCount;

    @OneToMany
    private Set<AuthorEntity> authors;

    public BookEntity(int isbn, String title, String author, String languages, int downloadCount, Set<AuthorEntity> authors) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.languages = languages;
        this.downloadCount = downloadCount;
        this.authors = authors;
    }

    public BookEntity(int isbn, String title, String author, String languages, int downloadCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    public BookEntity() {

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguages() {
        return languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }
}
