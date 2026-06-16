package com.ricardocampos.constructionapp.mapper;


import com.ricardocampos.constructionapp.dto.product.ProductCreateDto;
import com.ricardocampos.constructionapp.dto.product.ProductResponseDto;
import com.ricardocampos.constructionapp.dto.product.ProductSummaryDto;
import com.ricardocampos.constructionapp.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {


    Product toEntity(ProductCreateDto dto);

    ProductResponseDto toDto(Product product);

    ProductSummaryDto toSummaryDto(Product product);

}
