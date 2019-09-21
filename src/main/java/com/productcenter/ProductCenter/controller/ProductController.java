package com.productcenter.ProductCenter.controller;

import com.productcenter.ProductCenter.entity.Product;
import com.productcenter.ProductCenter.service.impl.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

}