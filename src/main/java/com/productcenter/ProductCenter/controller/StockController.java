package com.productcenter.ProductCenter.controller;

import com.productcenter.ProductCenter.service.impl.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StockController {

    private StockService stockService;

}
