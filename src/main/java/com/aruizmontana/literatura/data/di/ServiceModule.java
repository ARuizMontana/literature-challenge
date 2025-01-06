package com.aruizmontana.literatura.data.di;

import com.aruizmontana.literatura.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

@Service
public class ServiceModule {
    Retrofit retrofit;

    @Autowired
    public ServiceModule(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Bean
    BookService getBookService() {
        return retrofit.create(BookService.class);
    }
}
