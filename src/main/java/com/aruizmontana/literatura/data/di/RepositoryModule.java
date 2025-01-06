package com.aruizmontana.literatura.data.di;

import com.aruizmontana.literatura.data.datasource.AuthorLocalDataSource;
import com.aruizmontana.literatura.data.datasource.BookLocalDataSource;
import com.aruizmontana.literatura.data.datasource.BookRemoteDataSource;
import com.aruizmontana.literatura.data.datasource.HistoryLocalDataSource;
import com.aruizmontana.literatura.data.repository.AuthorRepositoryImpl;
import com.aruizmontana.literatura.data.repository.BookRepositoryImpl;
import com.aruizmontana.literatura.domain.repository.AuthorRepository;
import com.aruizmontana.literatura.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class RepositoryModule {

    private final BookRemoteDataSource dataSource;
    private final BookLocalDataSource bookDataSource;
    private final HistoryLocalDataSource historyDataSource;
    private final AuthorLocalDataSource authorDataSource;

    @Autowired
    public RepositoryModule(BookRemoteDataSource dataSource, BookLocalDataSource bookDataSource, HistoryLocalDataSource historyDataSource, AuthorLocalDataSource authorDataSource) {
        this.dataSource = dataSource;
        this.bookDataSource = bookDataSource;
        this.historyDataSource = historyDataSource;
        this.authorDataSource = authorDataSource;
    }

    @Bean
    @Primary
    BookRepository getBookRepository() {
        return new BookRepositoryImpl(dataSource, historyDataSource, bookDataSource, authorDataSource);
    }

    @Bean
    @Primary
    AuthorRepository getAuthorRepository() {
        return new AuthorRepositoryImpl(authorDataSource);
    }
}
