package com.productcenter.ProductCenter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    private Long id;
    private String name;
    private BigDecimal value;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
