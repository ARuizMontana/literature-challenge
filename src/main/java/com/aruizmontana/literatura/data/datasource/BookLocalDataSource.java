package com.aruizmontana.literatura.data.datasource;

import com.aruizmontana.literatura.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookLocalDataSource extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> searchAllByLanguagesContainingIgnoreCase(String language);
}
