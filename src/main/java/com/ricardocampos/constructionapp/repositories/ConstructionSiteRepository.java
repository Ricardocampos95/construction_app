package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import org.springframework.data.jpa.repository.JpaRepository;



import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite, UUID> {

    List<ConstructionSite> findByClientId(UUID id);
    List<ConstructionSite> findByLocationContainingIgnoreCase(String location);

    List<ConstructionSite> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate start, LocalDate end);

    List<ConstructionSite> findByStatus(ConstructionSiteStatus status);

    List<ConstructionSite> findByActiveFalseAndStatus(ConstructionSiteStatus status);

    boolean existsByLocationIgnoreCaseAndClientId(String location, UUID clientId);
    

}
