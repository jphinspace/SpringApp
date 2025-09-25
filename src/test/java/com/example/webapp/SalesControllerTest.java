package com.example.webapp;

import com.example.webapp.controller.SalesController;
import com.example.webapp.service.SalesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import com.example.webapp.model.SalesData;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(SalesController.class)
@Import({TestSecurityConfig.class, SalesControllerTest.TestConfig.class})
@org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc(addFilters = false)
public class SalesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SalesService salesService;

    @org.springframework.boot.test.context.TestConfiguration
    static class TestConfig {
        @Bean
        public SalesService salesService() {
            return Mockito.mock(SalesService.class);
        }

        @Bean
        public com.example.webapp.config.RateLimitProperties rateLimitProperties() {
            return Mockito.mock(com.example.webapp.config.RateLimitProperties.class);
        }
    }

    @Test
    void homePageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("bootstrap-demo"));
    }

    @Test
    void dashboardLoadsSuccessfully() throws Exception {
        Mockito.when(salesService.getAllSalesData()).thenReturn(Collections.emptyList());
        Mockito.when(salesService.getSalesByProduct()).thenReturn(Collections.emptyMap());
        mockMvc.perform(get("/dashboard"))
            .andExpect(status().isOk())
            .andExpect(view().name("dashboard"))
            .andExpect(model().attributeExists("salesData"))
            .andExpect(model().attributeExists("salesByProduct"))
            .andExpect(model().attributeExists("totalRevenue"))
            .andExpect(model().attributeExists("totalQuantity"))
            .andExpect(model().attributeExists("productCount"))
            .andExpect(model().attributeExists("avgRevenue"));
    }

    @Test
    void bootstrapDemoPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/bootstrap-demo"))
            .andExpect(status().isOk())
            .andExpect(view().name("bootstrap-demo"));
    }

    @Test
    void helloIndexPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/HELLO"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }

    @Test
    void helloWorldPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/HELLO/helloworld.html"))
            .andExpect(status().isOk())
            .andExpect(view().name("helloworld"));
    }

    @Test
    void dashboardCalculatesStatisticsCorrectly() throws Exception {
        // Create test data
        List<SalesData> testSales = Arrays.asList(
            new SalesData(java.time.LocalDate.now(), "Product A", 10, 100.0),
            new SalesData(java.time.LocalDate.now(), "Product B", 5, 50.0),
            new SalesData(java.time.LocalDate.now(), "Product A", 3, 30.0)
        );
        
        Mockito.when(salesService.getAllSalesData()).thenReturn(testSales);
        Mockito.when(salesService.getSalesByProduct()).thenReturn(Collections.emptyMap());
        
        mockMvc.perform(get("/dashboard"))
            .andExpect(status().isOk())
            .andExpect(view().name("dashboard"))
            .andExpect(model().attribute("totalRevenue", 180.0))
            .andExpect(model().attribute("totalQuantity", 18))
            .andExpect(model().attribute("productCount", 2L))
            .andExpect(model().attribute("avgRevenue", 60.0));
    }
}
