package com.productcenter.ProductCenter.repository;

import com.productcenter.ProductCenter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
