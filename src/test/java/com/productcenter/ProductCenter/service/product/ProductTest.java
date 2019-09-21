package com.productcenter.ProductCenter.service.product;

import com.productcenter.ProductCenter.entity.Product;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void dadoUmProdutoQuandoForCompletoEntaoSalvar() {
        Product produto = buildProduto(null);
        Mockito.when(productRepository.save(produto)).thenReturn(buildProduto(10L));

        Product result = productService.save(produto);

        Assert.assertThat(result.getId(), Matchers.equalTo(10L));

    }

    @Test
    public void dadoIdRetornarUmProduto() {
        Product product = buildProduto(null);
        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(buildProduto(10L)));

        Product result = productService.findById(product.getId());

        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            products.add(buildProduto(null));
        }

        Mockito.when(productRepository.findAll()).thenReturn(products);

    }

    private Product buildProduto(Long id) {
        return Product.builder()
                .id(id)
                .name("Smart 53")
                .value(BigDecimal.valueOf(2000))
                .createAt(LocalDateTime.now())
                .build();
    }
}
