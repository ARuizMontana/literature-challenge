package com.aruizmontana.literatura.data.datasource;

import com.aruizmontana.literatura.data.service.BookService;
import com.aruizmontana.literatura.domain.model.BookListModel;
import com.aruizmontana.literatura.domain.model.BookModel;
import com.aruizmontana.literatura.domain.response.ApiResponse;
import com.aruizmontana.literatura.domain.response.Result;

import java.util.Map;


public class BookRemoteDataSourceImpl implements BookRemoteDataSource {
    BookService service;

    public BookRemoteDataSourceImpl(BookService service) {
        this.service = service;
    }

    @Override
    public Result<BookListModel, String> getBookList() {
        return ApiResponse.tryCatch(service.getAllBooks(), Exception::getMessage);
    }

    @Override
    public Result<BookModel, String> getBookListBySearch(Map<String, String> filters) {
        var response =  ApiResponse.tryCatch(service.getAllBooksBySearch(filters), Exception::getMessage);
        if(response.isSuccess()) {
            var results = response.success().getResults();
            if(!results.isEmpty()) {
                return Result.success(results.get(0));
            } else {
                return Result.error("No books found");
            }
        }
       return Result.error("No books found");
    }

    @Override
    public Result<BookListModel, String> getBookListById(String ids) {
        return ApiResponse.tryCatch(service.getAllBooksById(ids), Exception::getMessage);
    }
}
