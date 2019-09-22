package com.productcenter.ProductCenter.mapper.stock;


import com.productcenter.ProductCenter.dto.StockDTO;
import com.productcenter.ProductCenter.entity.Product;
import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.mapper.StockMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockMapperTest {

    @MockBean
    private StockMapper stockMapper;

    @Test
    public void deveRetornarUmDto() {
        Stock stock = buildStock(null);
        Mockito.when(stockMapper.map(stock)).thenReturn(buildStockDTO(10L));
        StockDTO result = stockMapper.map(stock);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaListaDto() {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stocks.add(buildStock(null));
        }
        List<StockDTO> stocksDTO = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stocksDTO.add(buildStockDTO(null));
        }

        Mockito.when(stockMapper.mapList(stocks)).thenReturn(stocksDTO);
        List<StockDTO> result = stockMapper.mapList(stocks);
        Assert.assertThat(result, Matchers.equalTo(stocksDTO));
    }


    private StockDTO buildStockDTO(Long id) {
        return StockDTO.builder()
                .id(id)
                .quantity(20)
                .product(Product.builder().id(10L).build())
                .build();
    }


    private Stock buildStock(Long id) {
        return Stock.builder()
                .id(id)
                .quantity(20)
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .product(Product.builder().id(10L).build())
                .build();
    }

}
