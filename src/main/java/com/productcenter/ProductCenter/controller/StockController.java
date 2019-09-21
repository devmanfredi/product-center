package com.productcenter.ProductCenter.controller;

import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.service.impl.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;

    @PostMapping
    public Stock save(@RequestBody Stock stock) {
        return stockService.save(stock);
    }


}
