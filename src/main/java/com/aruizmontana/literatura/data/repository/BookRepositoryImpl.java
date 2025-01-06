package com.aruizmontana.literatura.data.repository;

import com.aruizmontana.literatura.data.datasource.AuthorLocalDataSource;
import com.aruizmontana.literatura.data.datasource.BookLocalDataSource;
import com.aruizmontana.literatura.data.datasource.BookRemoteDataSource;
import com.aruizmontana.literatura.data.datasource.HistoryLocalDataSource;
import com.aruizmontana.literatura.data.entity.BookEntity;
import com.aruizmontana.literatura.data.mapper.AuthorEntityMapper;
import com.aruizmontana.literatura.data.mapper.BookEntityMapper;
import com.aruizmontana.literatura.domain.mapper.BookMapper;
import com.aruizmontana.literatura.domain.model.BookListModel;
import com.aruizmontana.literatura.domain.model.BookResponseModel;
import com.aruizmontana.literatura.domain.repository.BookRepository;
import com.aruizmontana.literatura.domain.response.Result;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookRepositoryImpl implements BookRepository {

    HistoryLocalDataSource historyLocalDataSource;
    AuthorLocalDataSource authorLocalDataSource;
    BookLocalDataSource bookDataSource;
    BookRemoteDataSource remoteDataSource;

    public BookRepositoryImpl(BookRemoteDataSource remoteDataSource, HistoryLocalDataSource historyLocalDataSource, BookLocalDataSource bookDataSource, AuthorLocalDataSource authorLocalDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.historyLocalDataSource = historyLocalDataSource;
        this.bookDataSource = bookDataSource;
        this.authorLocalDataSource = authorLocalDataSource;
    }

    @Override
    public Result<List<BookResponseModel>, String> getBookLocalList() {
        var result = bookDataSource.findAll().stream().collect(Collectors.toMap(
                        BookEntity::getTitle,
                        book -> book,
                        (existing, replacement) -> existing
                ))
                .values()
                .stream().toList();
        if (result.isEmpty()) {
            return Result.error("No books found");
        }
        return Result.success(result.stream().map(BookEntityMapper::toResponseModel).toList());
    }

    @Override
    public Result<List<BookResponseModel>, String> getBookLocalListByLanguage(String language) {
        var result = bookDataSource.searchAllByLanguagesContainingIgnoreCase(language).stream().collect(Collectors.toMap(
                        BookEntity::getTitle,
                        book -> book,
                        (existing, replacement) -> existing
                ))
                .values()
                .stream().toList();
        if (result.isEmpty()) {
            return Result.error("No books found with language: " + language);
        }
        return Result.success(result.stream().map(BookEntityMapper::toResponseModel).toList());
    }

    @Override
    public Result<BookListModel, String> getBookList() {
        return remoteDataSource.getBookList();
    }

    @Override
    public Result<BookResponseModel, String> getBookListBySearch(Map<String, String> filters) {
        /// Validar si existe localmente
        var queryFilter = new Gson().toJson(filters);
        var localResponse = historyLocalDataSource.findFirstByQueryFilterEquals(queryFilter);
        if (localResponse != null) {
            /// Recuperar el book local y lo retorna
            var localBook = localResponse.getBook();
            return Result.success(BookEntityMapper.toResponseModel(localBook));
        }
        /// Hacer busqueda en la API
        var response = remoteDataSource.getBookListBySearch(filters);
        if (response.isSuccess()) {
            /// Guardar el resultado localmente
            var result = historyLocalDataSource.save(BookEntityMapper.toBookEntity(queryFilter, response.success()));
            /// Guardar los autores
            authorLocalDataSource.saveAll(Arrays.stream(response.success().getAuthors()).map(personModel -> AuthorEntityMapper.toEntity(personModel, result.getBook())).toList());
            /// Retorna los resultados del API
            return Result.success(BookMapper.toResponse(response.success()));
        }
        return Result.error(response.error());
    }

    @Override
    public Result<BookListModel, String> getBookListById(String ids) {
        return remoteDataSource.getBookListById(ids);
    }
}
