package com.productcenter.ProductCenter.controller.product;

import com.productcenter.ProductCenter.controller.ProductController;
import com.productcenter.ProductCenter.entity.Product;
import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.repository.ProductRepository;
import com.productcenter.ProductCenter.service.impl.ProductService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void deveSalvarProduto() {
        Product product = buildProduto(null);
        Mockito.when(productController.save(product)).thenReturn(buildProduto(10L));
        Product result = productController.save(product);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarProdutoPeloId() {
        Product product = buildProduto(null);
        Mockito.when(productController.findById(product.getId())).thenReturn(buildProduto(10L));
        Product result = productController.findById(product.getId());
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            products.add(buildProduto(null));
        }
        Mockito.when(productController.findAll()).thenReturn(products);
        List<Product> result = productController.findAll();
        Assert.assertThat(result, Matchers.equalTo(products));
    }

    private Product buildProduto(Long id) {
        return Product.builder()
                .id(id)
                .stock(Stock.builder().quantity(20).build())
                .name("Smart 53")
                .value(BigDecimal.valueOf(2000))
                .createAt(LocalDateTime.now())
                .build();
    }
}
