package com.productcenter.ProductCenter.mapper;

import com.productcenter.ProductCenter.dto.StockDTO;
import com.productcenter.ProductCenter.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    @Mappings({
            @Mapping(source = "id.product.id", target = "productId"),
            @Mapping(source = "id", target = "stockId"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "value", target = "value")
    })
    StockDTO map(Stock stock);

    List<StockDTO> map(List<Stock> stocks);


}
