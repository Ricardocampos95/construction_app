package com.ricardocampos.constructionapp.entities;

import com.ricardocampos.constructionapp.entities.keys.SupplierProductId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "supplier_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierProduct {

    @EmbeddedId
    private SupplierProductId id;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "lead_time", nullable = false)
    private Integer leadTime;

}
