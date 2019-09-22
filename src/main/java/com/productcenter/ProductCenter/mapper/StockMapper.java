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
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "product.id", target = "product.id")
    })
    StockDTO map(Stock stock);

    List<StockDTO> mapList(List<Stock> stocks);


}
