package com.example.webapp;

import com.example.webapp.controller.SalesController;
import com.example.webapp.service.SalesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(SalesController.class)
@Import(TestSecurityConfig.class)
@org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc(addFilters = false)
public class SalesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService salesService;

    @MockBean
    private com.example.webapp.config.RateLimitProperties rateLimitProperties;


    @Test
    void dashboardLoadsSuccessfully() throws Exception {
        Mockito.when(salesService.getAllSalesData()).thenReturn(Collections.emptyList());
        Mockito.when(salesService.getSalesByProduct()).thenReturn(Collections.emptyMap());
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("dashboard"))
            .andExpect(model().attributeExists("salesData"))
            .andExpect(model().attributeExists("salesByProduct"));
    }
}
