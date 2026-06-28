package com.ricardocampos.constructionapp.controllers;

import com.ricardocampos.constructionapp.dto.client.ClientCreateDto;
import com.ricardocampos.constructionapp.dto.client.ClientPatchDto;
import com.ricardocampos.constructionapp.dto.client.ClientResponseDto;
import com.ricardocampos.constructionapp.dto.client.ClientStatusDto;
import com.ricardocampos.constructionapp.services.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient (@Valid @RequestBody ClientCreateDto dto){

       ClientResponseDto response = service.createClient(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable UUID id){
        ClientResponseDto response = service.findById(id);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> findAll(){
        List<ClientResponseDto> listOfAll = service.findAll();

        return ResponseEntity.ok().body(listOfAll);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<ClientResponseDto>> findByName(
                @RequestParam @NotBlank(message = "O nome para pesquisa não pode estar vazio.") String name){
        List<ClientResponseDto> listOfAll = service.findByName(name);

        return ResponseEntity.ok((listOfAll));
    }

    @GetMapping("/search/nif")
    public ResponseEntity<ClientResponseDto> findByNif(
                @RequestParam @NotBlank(message = "O nif não pode estar vazio.") String nif){
        ClientResponseDto response = service.findByNif(nif);

        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateClient(
                @PathVariable @NotNull(message = "O id não pode ser nulo.") UUID id,
                @Valid @RequestBody ClientPatchDto dto){

        ClientResponseDto response = service.update(dto, id);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateClientStatus(
                @PathVariable @NotNull(message = "O id não pode ser nulo.") UUID id,
                @RequestBody ClientStatusDto dtoStatus){

    service.updateStatus(id, dtoStatus);
    return ResponseEntity.noContent().build();
    }


}
