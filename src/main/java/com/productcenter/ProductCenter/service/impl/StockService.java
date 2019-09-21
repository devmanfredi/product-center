package com.productcenter.ProductCenter.service.impl;

import com.productcenter.ProductCenter.entity.Stock;
import com.productcenter.ProductCenter.repository.StockRepository;
import com.productcenter.ProductCenter.service.interfaces.StockServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService implements StockServiceInterface {

    private StockRepository stockRepository;

    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock findById(Long stockId) {
        return stockRepository.findById(stockId).orElse(null);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

}
