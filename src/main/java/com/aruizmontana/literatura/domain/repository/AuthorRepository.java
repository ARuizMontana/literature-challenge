package com.aruizmontana.literatura.domain.repository;

import com.aruizmontana.literatura.domain.model.AuthorResponseModel;
import com.aruizmontana.literatura.domain.response.Result;

import java.util.List;

public interface AuthorRepository {
    Result<List<AuthorResponseModel>, String> getAuthorLocalList();
    Result<List<AuthorResponseModel>, String> getAuthorAliveLocalList(int year);
}
