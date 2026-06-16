package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.supplier.SupplierProductCreateDto;
import com.ricardocampos.constructionapp.dto.supplier.SupplierProductResponseDto;
import com.ricardocampos.constructionapp.entities.Product;
import com.ricardocampos.constructionapp.entities.Supplier;
import com.ricardocampos.constructionapp.entities.SupplierProduct;
import com.ricardocampos.constructionapp.entities.keys.SupplierProductId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {
                ProductMapper.class,
                SupplierMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SupplierProductMapper {


    default SupplierProduct toEntity(
                             SupplierProductCreateDto dto,
                             Product product,
                             Supplier supplier
    ){

        SupplierProductId id = new SupplierProductId(
                supplier.getId(),
                product.getId()
        );

        SupplierProduct supplierProduct = new SupplierProduct();
        supplierProduct.setId(id);
        supplierProduct.setPrice(dto.price());
        supplierProduct.setLeadTime(dto.leadTime());
        supplierProduct.setProduct(product);
        supplierProduct.setSupplier(supplier);

        return supplierProduct;
    }

    SupplierProductResponseDto toDto(SupplierProduct entity);
    SupplierProductResponseDto toSummaryDto(SupplierProduct entity);


}
