package com.productcenter.ProductCenter.service.impl;

import com.productcenter.ProductCenter.repository.StockRepository;
import com.productcenter.ProductCenter.service.interfaces.StockServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService implements StockServiceInterface {

    private StockRepository stockRepository;

}
