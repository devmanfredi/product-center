package com.productcenter.ProductCenter.controller;

import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.service.impl.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;

    @PostMapping
    public Stock save(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @GetMapping("/{stockId}")
    public Stock findById(@PathVariable Long stockId) {
        return stockService.findById(stockId);
    }

    @GetMapping
    public List<Stock> findAll() {
        return stockService.findAll();
    }


}
