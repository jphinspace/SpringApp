package com.example.webapp.repository;

import com.example.webapp.model.SalesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalesRepository extends JpaRepository<SalesData, Long> {
    @Query("SELECT s FROM SalesData s ORDER BY s.date")
    List<SalesData> findAllOrderByDate();
    
    List<SalesData> findByProduct(String product);
}