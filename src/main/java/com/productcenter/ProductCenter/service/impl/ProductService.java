package com.productcenter.ProductCenter.service.impl;

import com.productcenter.ProductCenter.entity.Product;
import com.productcenter.ProductCenter.repository.ProductRepository;
import com.productcenter.ProductCenter.service.interfaces.ProductServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
