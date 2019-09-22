package com.productcenter.ProductCenter.mapper;

import com.productcenter.ProductCenter.dto.ProductDTO;
import com.productcenter.ProductCenter.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "id.stock.id", target = "stock.id")
    })
    ProductDTO map(Product product);

    List<ProductDTO> mapList(List<Product> products);


}
