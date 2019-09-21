package com.productcenter.ProductCenter.controller;

import com.productcenter.ProductCenter.service.impl.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


}
