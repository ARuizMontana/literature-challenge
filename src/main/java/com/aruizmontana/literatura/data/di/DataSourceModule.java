package com.aruizmontana.literatura.data.di;

import com.aruizmontana.literatura.data.datasource.BookRemoteDataSource;
import com.aruizmontana.literatura.data.datasource.BookRemoteDataSourceImpl;
import com.aruizmontana.literatura.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DataSourceModule {

    BookService service;

    @Autowired
    public DataSourceModule(BookService service) {
        this.service = service;
    }

    @Bean
    BookRemoteDataSource getBookRemoteDataSource() {
        return new BookRemoteDataSourceImpl(service);
    }
}
