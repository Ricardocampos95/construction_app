package com.ricardocampos.constructionapp.mapper;

import com.ricardocampos.constructionapp.dto.stockmovement.StockMovementCreateDto;
import com.ricardocampos.constructionapp.dto.stockmovement.StockMovementResponseDto;
import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.entities.Employee;
import com.ricardocampos.constructionapp.entities.Product;
import com.ricardocampos.constructionapp.entities.StockMovement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;


@Mapper(componentModel = "spring",
        uses = {
            ProductMapper.class,
            EmployeeMapper.class,
            ConstructionSiteMapper.class
                        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StockMovementMapper {

    default StockMovement toEntity(
                    StockMovementCreateDto dto,
                    ConstructionSite constructionSite,
                    Employee employee,
                    Product product){

       StockMovement stockMovement = new StockMovement();

       stockMovement.setMovementType(dto.movementType());
       stockMovement.setConstructionSite(constructionSite);
       stockMovement.setDate(LocalDateTime.now());
       stockMovement.setProduct(product);
       stockMovement.setQuantity(dto.quantity());
       stockMovement.setEmployee(employee);

       return stockMovement;
    }


    StockMovementResponseDto toDto(StockMovement entity);


}
