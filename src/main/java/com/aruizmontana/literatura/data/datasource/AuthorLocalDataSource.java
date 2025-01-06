package com.aruizmontana.literatura.data.datasource;

import com.aruizmontana.literatura.data.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorLocalDataSource extends JpaRepository<AuthorEntity, Integer> {

    @Query("SELECT a FROM AuthorEntity a WHERE a.deathYear > :year")
    List<AuthorEntity> findByDeathYearAfter(int year);
}
