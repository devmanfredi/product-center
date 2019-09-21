package com.productcenter.ProductCenter.controller.stock;

import com.productcenter.ProductCenter.controller.StockController;
import com.productcenter.ProductCenter.entity.Product;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {

    @Autowired
    StockController stockController;

    @MockBean
    private StockService stockService;

    @MockBean
    private StockRepository stockRepository;

    @Test
    public void deveSalvarStock() {
        Stock stock = stockBuild(null);
        Mockito.when(stockController.save(stock)).thenReturn(stockBuild(10L));
        Stock result = stockController.save(stock);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarStockPeloId() {
        Stock stock = stockBuild(null);
        Mockito.when(stockController.findById(stock.getId())).thenReturn(stockBuild(10L));
        Stock result = stockController.findById(stock.getId());
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stocks.add(stockBuild(null));
        }
        Mockito.when(stockController.findAll()).thenReturn(stocks);
    }

    private Stock stockBuild(Long id) {
        return Stock.builder()
                .id(id)
                .product(Product.builder().name("Smart").build())
                .quantity(20)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
