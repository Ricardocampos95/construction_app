package com.ricardocampos.constructionapp.entities;


import com.ricardocampos.constructionapp.enums.StockMovementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_movement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMovement {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "stock_movement_id")
    private UUID id;

    @Column(name = "quantity", nullable = false, precision = 10, scale = 2)
    private BigDecimal quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private StockMovementType movementType;

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    //employee_id
    //construction_site_id
    //product_id






}
