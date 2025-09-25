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
    public String home() {
        return "bootstrap-demo";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<SalesData> allSales = salesService.getAllSalesData();
        Map<String, List<SalesData>> salesByProduct = salesService.getSalesByProduct();
        
        // Calculate summary statistics
        double totalRevenue = allSales.stream().mapToDouble(SalesData::getRevenue).sum();
        int totalQuantity = allSales.stream().mapToInt(SalesData::getQuantity).sum();
        long productCount = allSales.stream().map(SalesData::getProduct).distinct().count();
        double avgRevenue = allSales.stream().mapToDouble(SalesData::getRevenue).average().orElse(0.0);
        
        model.addAttribute("salesData", allSales);
        model.addAttribute("salesByProduct", salesByProduct);
        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("productCount", productCount);
        model.addAttribute("avgRevenue", avgRevenue);
        return "dashboard";
    }

    @GetMapping("/bootstrap-demo")
    public String bootstrapDemo() {
        return "bootstrap-demo";
    }

    @GetMapping("/HELLO")
    public String index() {
        return "index";
    }

    @GetMapping("/HELLO/helloworld.html")
    public String someRandomMethodName() {
        return "helloworld";
    }
}