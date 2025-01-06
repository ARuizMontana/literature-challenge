package com.aruizmontana.literatura.domain.repository;

import com.aruizmontana.literatura.domain.model.BookListModel;
import com.aruizmontana.literatura.domain.model.BookResponseModel;
import com.aruizmontana.literatura.domain.response.Result;

import java.util.List;
import java.util.Map;

public interface BookRepository {
    Result<List<BookResponseModel>, String> getBookLocalList();
    Result<List<BookResponseModel>, String> getBookLocalListByLanguage(String language);
    Result<BookListModel, String> getBookList();
    Result<BookResponseModel, String> getBookListBySearch(Map<String, String> filters);
    Result<BookListModel, String> getBookListById(String ids);
}
