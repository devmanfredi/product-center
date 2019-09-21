package com.productcenter.ProductCenter.dto;

import com.productcenter.ProductCenter.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {

    private Long id;
    private Integer quantity;
    private Product product;
}
