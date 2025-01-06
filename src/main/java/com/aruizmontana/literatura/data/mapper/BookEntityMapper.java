package com.aruizmontana.literatura.data.mapper;

import com.aruizmontana.literatura.data.entity.BookEntity;
import com.aruizmontana.literatura.data.entity.HistoryEntity;
import com.aruizmontana.literatura.domain.model.BookModel;
import com.aruizmontana.literatura.domain.model.BookResponseModel;
import com.aruizmontana.literatura.domain.model.PersonModel;

import java.util.Arrays;


public class BookEntityMapper {
    public static BookResponseModel toResponseModel(BookEntity book) {
        return new BookResponseModel(
                book.getTitle(),
                book.getAuthor(),
                book.getLanguages(),
                book.getDownloadCount()
        );
    }

    public static HistoryEntity toBookEntity(String queryFilter, BookModel book) {
        return new HistoryEntity(
                queryFilter,
                new BookEntity(
                        book.getId(),
                        book.getTitle(),
                        String.join(" - ", Arrays.stream(book.getAuthors()).map(PersonModel::getName).toList()),
                        String.join(" , ", book.getLanguages()),
                        book.getDownloadCount()
                )
        );
    }
}
