package com.aruizmontana.literatura.data.datasource;

import com.aruizmontana.literatura.domain.model.BookListModel;
import com.aruizmontana.literatura.domain.model.BookModel;
import com.aruizmontana.literatura.domain.response.Result;

import java.util.Map;

public interface BookRemoteDataSource {
    Result<BookListModel, String> getBookList();
    Result<BookModel, String> getBookListBySearch(Map<String, String> filters);
    Result<BookListModel, String> getBookListById(String ids);
}
