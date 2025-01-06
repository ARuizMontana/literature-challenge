package com.aruizmontana.literatura.data.mapper;

import com.aruizmontana.literatura.data.entity.AuthorEntity;
import com.aruizmontana.literatura.data.entity.BookEntity;
import com.aruizmontana.literatura.domain.model.AuthorResponseModel;
import com.aruizmontana.literatura.domain.model.PersonModel;

public class AuthorEntityMapper {
    public static AuthorResponseModel toModelResponse(AuthorEntity entity) {
        return new AuthorResponseModel(
                entity.getName(),
                entity.getBirthYear(),
                entity.getDeathYear()
        );
    }

    public static AuthorEntity toEntity(PersonModel model) {
        return new AuthorEntity(
                model.getName(),
                model.getBirthYear(),
                model.getDeathYear()
        );
    }
    public static AuthorEntity toEntity(PersonModel model, BookEntity book) {
        return new AuthorEntity(
                model.getName(),
                model.getBirthYear(),
                model.getDeathYear(),
                book
        );
    }
}
