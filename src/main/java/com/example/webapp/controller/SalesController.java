package com.example.webapp.controller;

import com.example.webapp.model.SalesData;
import com.example.webapp.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;

@Controller
public class SalesController {
    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/")
    public String showDashboard(Model model) {
        List<SalesData> allSales = salesService.getAllSalesData();
        Map<String, List<SalesData>> salesByProduct = salesService.getSalesByProduct();
        
        model.addAttribute("salesData", allSales);
        model.addAttribute("salesByProduct", salesByProduct);
        return "dashboard";
    }
}