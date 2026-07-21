package com.ricardocampos.constructionapp.controllers;

import com.ricardocampos.constructionapp.dto.vehicle.VehicleCreateDto;
import com.ricardocampos.constructionapp.dto.vehicle.VehicleResponseDto;
import com.ricardocampos.constructionapp.entities.Vehicle;
import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;
import com.ricardocampos.constructionapp.services.VehicleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@Validated
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> findById(@NotNull(message = "Id é obrigatório.")
                                                       @PathVariable UUID id){

        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping("/internalCode")
    public ResponseEntity<VehicleResponseDto> findEntityByInternalCode(@NotNull(message = "O código interno é obrigatório.")
                                                                       @RequestParam String internalCode){

        return ResponseEntity.ok(service.findByInternalCode(internalCode));
    }

    @GetMapping("/status")
    public ResponseEntity<List<VehicleResponseDto>> findByStatus(@NotNull(message = "O status é obrigatório.")
                                                           @RequestParam VehicleStatus status){

        return ResponseEntity.ok(service.findByStatus(status));

    }

    @GetMapping("/licenseplate")
    public ResponseEntity<VehicleResponseDto> findByLicensePlate(@NotBlank(message = "A matricula é obrigatória e com o formato correto.")
                                                                 @PathVariable String license){

        return ResponseEntity.ok(service.findByLicensePlate(license));
    }


    @GetMapping("/vehicletype")
    public ResponseEntity<List<VehicleResponseDto>> findByVehicleType(@NotNull(message = "O tipo do veículo é obrigatório.")
                                                                      @PathVariable VehicleType vehicleType){

        return ResponseEntity.ok(service.findByVehicleType(vehicleType));
    }

    @GetMapping("/brand")
    public ResponseEntity<List<VehicleResponseDto>> findByBrand(@NotBlank(message = "A marca é obrigatória.")
                                                         @PathVariable String brand){

        return ResponseEntity.ok(service.findByBrand(brand));
    }

    @PostMapping()
    public ResponseEntity<VehicleResponseDto> create(@Valid @RequestBody VehicleCreateDto request){

       VehicleResponseDto dto = service.create(request);

      URI uri = ServletUriComponentsBuilder
              .fromCurrentRequest()
              .path("/{id}")
              .buildAndExpand(dto.id())
              .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PatchMapping()
    public ResponseEntity<VehicleResponseDto> update(@Valid @RequestBody VehicleCreateDto request,
                                                     @NotNull(message = "O id é obrigatório.") UUID id)
    {
                return ResponseEntity.ok(service.update(request, id));
    }












}
