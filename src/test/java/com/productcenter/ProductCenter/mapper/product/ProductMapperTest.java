package com.productcenter.ProductCenter.mapper.product;


import com.productcenter.ProductCenter.dto.ProductDTO;
import com.productcenter.ProductCenter.entity.Product;
import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.mapper.ProductMapper;
import com.productcenter.ProductCenter.repository.ProductRepository;
import com.productcenter.ProductCenter.service.impl.ProductService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductService productService;

    private ProductMapper productMapper;

    @Test
    public void deveRetornarUmDto() {
        Product product = buildProduct(null);
        Mockito.when(productMapper.map(product)).thenReturn(buildProductDTO(10L));
        ProductDTO productDTO = productMapper.map(product);
        Assert.assertThat(productDTO.getId(), Matchers.equalTo(10L));
    }


    private ProductDTO buildProductDTO(Long id) {
        return ProductDTO.builder()
                .id(id)
                .name("Smart 53")
                .value(BigDecimal.valueOf(2000))
                .stock(Stock.builder().id(15L).build())
                .build();
    }


    private Product buildProduct(Long id) {
        return Product.builder()
                .id(id)
                .stock(Stock.builder().id(15L).build())
                .name("Smart 53")
                .value(BigDecimal.valueOf(2000))
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
    }

}
