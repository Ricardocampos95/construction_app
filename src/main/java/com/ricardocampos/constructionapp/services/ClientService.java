package com.ricardocampos.constructionapp.services;

import com.ricardocampos.constructionapp.dto.client.ClientCreateDto;
import com.ricardocampos.constructionapp.dto.client.ClientResponseDto;
import com.ricardocampos.constructionapp.dto.client.ClientStatusDto;
import com.ricardocampos.constructionapp.entities.Client;
import com.ricardocampos.constructionapp.exceptions.AlreadyExistsException;
import com.ricardocampos.constructionapp.exceptions.ResourceNotFoundException;
import com.ricardocampos.constructionapp.mapper.ClientMapper;
import com.ricardocampos.constructionapp.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClientResponseDto createClient (ClientCreateDto dto){

        boolean hasClient = repository.existsByEmail(dto.email());

        if(hasClient){
            throw new AlreadyExistsException("Cliente já registado com o email: " + dto.email());
        }

        Client client = mapper.toEntity(dto);

        repository.save(client);

        return mapper.toDto(client);
    }

    public ClientResponseDto findById(UUID id){

        Objects.requireNonNull(id, "O id do cliente não pode ser nulo.");

       Client client = repository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));

        return mapper.toDto(client);
    }

    public List<ClientResponseDto> findAll(){
        List<Client> clients = repository.findAll();

        return clients.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ClientResponseDto> findByName(String name){

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("O nome para pesquisa não pode estar vazio.");
        }

        List<Client> clients = repository.findByNameContainingIgnoreCase(name);

        return clients.stream()
                .map(mapper::toDto)
                .toList();
    }

    public ClientResponseDto findByNif(String nif){

        if (nif == null || nif.isBlank()){
            throw new IllegalArgumentException(("O nif não pode estar vazio ou inválido."));
        }

        Client client = repository.findByNif(nif)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));

        return mapper.toDto(client);

    }

    @Transactional
    public ClientResponseDto update (ClientCreateDto dto, UUID id){
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));

        mapper.updateEntityFromDto(dto, client);

        repository.save(client);

        return mapper.toDto(client);
    }

    @Transactional
    public void updateStatus(UUID id, ClientStatusDto status){

        Objects.requireNonNull(id, "O id do cliente não pode ser nulo.");
        Objects.requireNonNull(status, "O status não pode ser nulo.");

        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client não encontrado."));

        client.setActive(status.active());
        repository.save(client);
    }




































}
