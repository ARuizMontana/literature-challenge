package com.aruizmontana.literatura.data.repository;

import com.aruizmontana.literatura.data.datasource.AuthorLocalDataSource;
import com.aruizmontana.literatura.data.entity.AuthorEntity;
import com.aruizmontana.literatura.data.mapper.AuthorEntityMapper;
import com.aruizmontana.literatura.domain.model.AuthorResponseModel;
import com.aruizmontana.literatura.domain.repository.AuthorRepository;
import com.aruizmontana.literatura.domain.response.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorRepositoryImpl implements AuthorRepository {
    AuthorLocalDataSource authorDataSource;

    public AuthorRepositoryImpl(AuthorLocalDataSource authorDataSource) {
        this.authorDataSource = authorDataSource;
    }

    @Override
    public Result<List<AuthorResponseModel>, String> getAuthorLocalList() {
        var result = authorDataSource.findAll().stream().collect(
                        Collectors.toMap(
                                AuthorEntity::getName,
                                author -> author,
                                (existing, replacement) -> existing
                        ))
                .values()
                .stream().toList();
        if (result.isEmpty()) {
            return Result.error("No authors found");
        }
        return Result.success(result.stream().map(AuthorEntityMapper::toModelResponse).toList());
    }

    @Override
    public Result<List<AuthorResponseModel>, String> getAuthorAliveLocalList(int year) {
        var result = authorDataSource.findByDeathYearAfter(year).stream().collect(
                        Collectors.toMap(
                                AuthorEntity::getName,
                                author -> author,
                                (existing, replacement) -> existing
                        ))
                .values()
                .stream().toList();
        if (result.isEmpty()) {
            return Result.error("No authors found alive in year: " + year);
        }
        return Result.success(result.stream().map(AuthorEntityMapper::toModelResponse).toList());
    }
}
