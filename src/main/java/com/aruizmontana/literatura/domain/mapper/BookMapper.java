package com.aruizmontana.literatura.domain.mapper;

import com.aruizmontana.literatura.domain.model.BookModel;
import com.aruizmontana.literatura.domain.model.BookResponseModel;
import com.aruizmontana.literatura.domain.model.PersonModel;

import java.util.Arrays;


public class BookMapper {
    public static BookResponseModel toResponse(BookModel book) {
        return new BookResponseModel(
                book.getTitle(),
                String.join(" - ", Arrays.stream(book.getAuthors()).map(PersonModel::getName).toList()),
                String.join(" , ", book.getLanguages()),
                book.getDownloadCount()
        );
    }
}
