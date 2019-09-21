package com.productcenter.ProductCenter.repository;

import com.productcenter.ProductCenter.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
