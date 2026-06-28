package com.ricardocampos.constructionapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.LAZY
    )
    private List<ConstructionSite> constructionSiteList;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "nif", unique = true, nullable = false, length = 20)
    private String nif;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "phone", length = 100)
    private String phoneNumber;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active = true;

}
