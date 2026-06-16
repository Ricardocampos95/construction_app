package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.supplier.SupplierCreateDto;
import com.ricardocampos.constructionapp.dto.supplier.SupplierResponseDto;
import com.ricardocampos.constructionapp.dto.supplier.SupplierSummaryDto;
import com.ricardocampos.constructionapp.entities.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SupplierMapper {

    Supplier toEntity(SupplierCreateDto dto);
    SupplierResponseDto toDto(Supplier entity);
    SupplierSummaryDto toSummaryDto(Supplier entity);
}
