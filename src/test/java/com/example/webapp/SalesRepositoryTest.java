package com.example.webapp;

import com.example.webapp.model.SalesData;
import com.example.webapp.repository.SalesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SalesRepositoryTest {
    @Autowired
    private SalesRepository salesRepository;

    @Test
    void findAllOrderByDateReturnsData() {
        List<SalesData> sales = salesRepository.findAllOrderByDate();
        assertThat(sales).isNotNull();
    }

    @Test
    void findByProductReturnsCorrectData() {
        List<SalesData> sales = salesRepository.findByProduct("Product A");
        assertThat(sales).allMatch(s -> "Product A".equals(s.getProduct()));
    }
}
