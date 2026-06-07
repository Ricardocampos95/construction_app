package com.ricardocampos.constructionapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fuel_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelRecord {

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "fuel_record_id")
    private UUID id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "liters", nullable = false, precision = 10, scale = 2)
    private BigDecimal liters;

    @Column(name = "km_hours", nullable = false, precision = 10, scale = 2)
    private BigDecimal kmHours;

    @Column(name = "cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;




}
