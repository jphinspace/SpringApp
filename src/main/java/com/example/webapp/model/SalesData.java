package com.example.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class SalesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    private String product;
    private Integer quantity;
    private Double revenue;
    
    public SalesData(LocalDate date, String product, Integer quantity, Double revenue) {
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.revenue = revenue;
    }
}