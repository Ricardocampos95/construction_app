package com.ricardocampos.constructionapp.services;

import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteCreateDto;
import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteResponseDto;
import com.ricardocampos.constructionapp.dto.constructionsite.ConstructionSiteUpdateDto;
import com.ricardocampos.constructionapp.entities.ConstructionSite;
import com.ricardocampos.constructionapp.enums.ConstructionSiteStatus;
import com.ricardocampos.constructionapp.exceptions.BusinessException;
import com.ricardocampos.constructionapp.exceptions.ResourceNotFoundException;
import com.ricardocampos.constructionapp.mapper.ConstructionSiteMapper;
import com.ricardocampos.constructionapp.repositories.ConstructionSiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ConstructionSiteService {


    private final ConstructionSiteRepository repository;
    private final ConstructionSiteMapper mapper;

    public ConstructionSiteService(ConstructionSiteRepository repository, ConstructionSiteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ConstructionSiteResponseDto findById(UUID id){

        Objects.requireNonNull(id, "O id não pode ser nulo");

        ConstructionSite constructionSite = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada."));

        return mapper.toDto(constructionSite);
    }

    public List<ConstructionSiteResponseDto> findArchived(){
            List<ConstructionSite> listOfAll = repository.findByActiveFalseAndStatus(ConstructionSiteStatus.FINISHED);

            return listOfAll.stream()
                    .map(mapper::toDto)
                    .toList();
    }


    public List<ConstructionSiteResponseDto> findAll(){
        List<ConstructionSite> entityList = repository.findAll();

        return entityList.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ConstructionSiteResponseDto> findByClientId(UUID id){
          Objects.requireNonNull(id, "O id do cliente não pode ser nulo.");

          return repository.findByClientId(id)
                  .stream()
                  .map(mapper::toDto)
                  .toList();
    }

    public List<ConstructionSiteResponseDto> findByLocation(String location){
        Objects.requireNonNull(location, "A localização não pode ser nula.");

        return repository.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ConstructionSiteResponseDto> findByDateBetween(LocalDate startDate, LocalDate endDate){
        Objects.requireNonNull(startDate, "A data de inicio não pode ser nula.");
        Objects.requireNonNull(endDate, "A data de fim não pode ser nula.");

        if (startDate.isAfter(endDate)){
            throw new BusinessException("A data de ínicio não pode ser posterior à de fim.");
        }

        return repository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ConstructionSiteResponseDto> findByStatus(ConstructionSiteStatus status){

        Objects.requireNonNull(status, "O status não pode ser nulo");

        return repository.findByStatus(status)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ConstructionSiteResponseDto create(ConstructionSiteCreateDto request){
        boolean exists = repository.existsByLocationIgnoreCaseAndClientId(request.location().trim(), request.clientId());

        if(exists){
            throw new BusinessException("Já existe uma obra para este cliente, nesta morada.");
        }

        ConstructionSite entity = mapper.toEntity(request);

        ConstructionSite savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Transactional
    public ConstructionSiteResponseDto update(UUID id, ConstructionSiteUpdateDto dto){
        ConstructionSite entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada"));

        if (dto.endDate() != null){
            if (dto.endDate().isBefore(entity.getStartDate())){
                throw new BusinessException("A obra não pode terminar antes de comecar.");
            }
        }

        if (dto.status() != null && entity.getStatus() == ConstructionSiteStatus.FINISHED){
            throw new BusinessException("A obra já está finalizada, não pode ser alterada.");
        }


        mapper.updateEntityFromDto(dto, entity);

        repository.save(entity);

        return mapper.toDto(entity);
    }

    public void delete(UUID id){
        ConstructionSite entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada."));

        if(!entity.getActive()){
            throw new BusinessException("A obra já está encerrada!");
        }

        if(entity.getEndDate() == null || entity.getStatus() == ConstructionSiteStatus.FINISHED){
            throw new BusinessException("A obra tem de estar concluida e ter data de fim para ser encerrada!");
        }

        repository.deleteById(id);
    }








}
