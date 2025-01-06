package com.aruizmontana.literatura.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyId")
    private int id;
    @Column(unique = true, nullable = false)
    private String queryFilter;
    @OneToOne
    @MapsId
    private BookEntity book;

    public HistoryEntity() {}

    public HistoryEntity(String queryFilter, BookEntity book) {
        this.queryFilter = queryFilter;
        this.book = book;
    }

    public BookEntity getBook() {
        return book;
    }
}
