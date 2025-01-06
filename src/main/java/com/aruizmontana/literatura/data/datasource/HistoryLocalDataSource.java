package com.aruizmontana.literatura.data.datasource;

import com.aruizmontana.literatura.data.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryLocalDataSource extends JpaRepository<HistoryEntity, Integer> {
    HistoryEntity findFirstByQueryFilterEquals(String queryFilter);
}
