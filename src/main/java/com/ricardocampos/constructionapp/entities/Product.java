package com.ricardocampos.constructionapp.entities;


import com.ricardocampos.constructionapp.enums.UnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<StockMovement> stockMovements;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private UnitType unitType;

    @Column(name = "reference", nullable = false, unique = true)
    private String reference;

    @Column(name = "min_stock_alert", nullable = false, precision = 10, scale = 2)
    private BigDecimal minStockAlert;

}
