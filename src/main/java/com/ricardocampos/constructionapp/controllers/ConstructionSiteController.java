package com.ricardocampos.constructionapp.controllers;

import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteCreateDto;
import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteResponseDto;
import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteUpdateDto;
import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import com.ricardocampos.constructionapp.services.ConstructionSiteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/constructionSite")
@Validated
public class ConstructionSiteController {

    private final ConstructionSiteService service;

    public ConstructionSiteController(ConstructionSiteService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConstructionSiteResponseDto> findById(@Valid @PathVariable UUID id){
            ConstructionSiteResponseDto response = service.findById(id);

            return ResponseEntity.ok(response);
    }


    @GetMapping("/archived")
    public ResponseEntity<List<ConstructionSiteResponseDto>> findArchivedById(){
        List<ConstructionSiteResponseDto> response = service.findArchived();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ConstructionSiteResponseDto>> findAll(){

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ConstructionSiteResponseDto>> findByClientId(@Valid @PathVariable UUID id){

        List<ConstructionSiteResponseDto> listOfContructionsByClientId = service.findByClientId(id);

        return ResponseEntity.ok(listOfContructionsByClientId);
    }

    @GetMapping("/location")
    public ResponseEntity<List<ConstructionSiteResponseDto>> findByLocation(
            @RequestParam
            @NotBlank(message = "A localização é obrigatória.") String location
    ){

        List<ConstructionSiteResponseDto> listOfConstructionSitesByLocation = service.findByLocation(location);

        return ResponseEntity.ok(listOfConstructionSitesByLocation);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<ConstructionSiteResponseDto>> findByDateBetween(
            @RequestParam @NotNull(message = "A data de inicio não pode ser nula.")  LocalDate start,
            @RequestParam @NotNull(message = "A data de fim não pode ser nula.")  LocalDate end
    ){

        List<ConstructionSiteResponseDto> listOfConstructionSiteByDates = service.findByDateBetween(start, end);

        return ResponseEntity.ok(listOfConstructionSiteByDates);
    }

    @GetMapping("/status")
    public ResponseEntity<List<ConstructionSiteResponseDto>> findByStatus (@RequestParam ConstructionSiteStatus status){

        List<ConstructionSiteResponseDto> listOfConstructionSitesByStatus = service.findByStatus(status);

        return ResponseEntity.ok(listOfConstructionSitesByStatus);
    }


    @PostMapping
    public ResponseEntity<ConstructionSiteResponseDto> create(@Valid @RequestBody ConstructionSiteCreateDto dto){
        ConstructionSiteResponseDto response = service.create(dto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ConstructionSiteResponseDto> update(@Valid @RequestBody ConstructionSiteUpdateDto dto,
                                                              @Valid @PathVariable UUID id){

        ConstructionSiteResponseDto response = service.update(id,dto);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }






}
