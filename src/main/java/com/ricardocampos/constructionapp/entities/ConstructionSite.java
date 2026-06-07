package com.ricardocampos.constructionapp.entities;

import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "construction_site")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionSite {

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "constructionSite",
            fetch = FetchType.LAZY)
    private List<StockMovement> stockMovements;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "construction_site_id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "location", nullable = false, length = 255)
    private String location;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ConstructionSiteStatus status;

}
