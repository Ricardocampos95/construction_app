package com.ricardocampos.constructionapp.entities;

import com.ricardocampos.constructionapp.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE employee SET active = false WHERE id ?")
@SQLRestriction("active = true")
public class Employee {

    @OneToMany(mappedBy = "employee",
            fetch = FetchType.LAZY)
    private List<FuelRecord> fuelRecords;

    @OneToMany(mappedBy = "employee",
            fetch = FetchType.LAZY)
    private List<StockMovement> stockMovements;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private EmployeeRole role;

    @Column(name = "active", nullable = false)
    private boolean active = true;
}
