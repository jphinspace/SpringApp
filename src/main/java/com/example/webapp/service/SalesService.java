package com.example.webapp.service;

import com.example.webapp.model.SalesData;
import com.example.webapp.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalesService {
    private final SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<SalesData> getAllSalesData() {
        return salesRepository.findAllOrderByDate();
    }

    public Map<String, List<SalesData>> getSalesByProduct() {
        return salesRepository.findAllOrderByDate().stream()
                .collect(Collectors.groupingBy(SalesData::getProduct));
    }

    public List<SalesData> getSalesForProduct(String product) {
        return salesRepository.findByProduct(product);
    }
}