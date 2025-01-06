package com.aruizmontana.literatura.data.service;

import com.aruizmontana.literatura.domain.model.BookListModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface BookService {
    @GET("/books")
    Call<BookListModel> getAllBooks();

    @GET("/books")
    Call<BookListModel> getAllBooksBySearch(@QueryMap(encoded = true) Map<String, String> options);

    @GET("/books")
    Call<BookListModel> getAllBooksById(@Query("ids") String ids);
}
