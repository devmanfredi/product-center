package com.productcenter.ProductCenter.service.stock;

import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.repository.StockRepository;
import com.productcenter.ProductCenter.service.impl.StockService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTest {

    @Autowired
    private StockService stockService;

    @MockBean
    private StockRepository stockRepository;

    @Test
    public void dadoUmStockQuandoForCompletoEntaoSalvar() {
        Stock stock = buildStock(null);
        Mockito.when(stockRepository.save(stock)).thenReturn(buildStock(10L));

        Stock result = stockService.save(stock);

        Assert.assertThat(result.getId(), Matchers.equalTo(10L));

    }

    @Test
    public void dadoIdRetornarUmStock() {
        Stock stock = buildStock(null);
        Mockito.when(stockRepository.findById(stock.getId())).thenReturn(Optional.of(buildStock(10L)));

        Stock result = stockService.findById(stock.getId());

        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stocks.add(buildStock(null));
        }

        Mockito.when(stockRepository.findAll()).thenReturn(stocks);

    }

    private Stock buildStock(Long id) {
        return Stock.builder()
                .id(id)
                .quantity(100)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
