package com.ricardocampos.constructionapp.services;

import com.ricardocampos.constructionapp.dto.vehicle.VehicleCreateDto;
import com.ricardocampos.constructionapp.dto.vehicle.VehicleResponseDto;
import com.ricardocampos.constructionapp.entities.Vehicle;
import com.ricardocampos.constructionapp.enums.VehicleStatus;
import com.ricardocampos.constructionapp.enums.VehicleType;
import com.ricardocampos.constructionapp.exceptions.BusinessException;
import com.ricardocampos.constructionapp.exceptions.ResourceNotFoundException;
import com.ricardocampos.constructionapp.mapper.VehicleMapper;
import com.ricardocampos.constructionapp.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    private static final Pattern PT_LICENSE_PLATE_PATTERN = Pattern.compile("^(([A-Z]{2}-\\d{2}-\\d{2})|(\\d{2}-\\d{2}-[A-Z]{2})|(\\d{2}-[A-Z]{2}-\\d{2})|([A-Z]{2}-[A-Z]{2}-\\d{2}))$");
    public VehicleService(VehicleRepository repository, VehicleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<VehicleResponseDto> findAll(){
        List<Vehicle> vehiclesList = repository.findAll();

        return vehiclesList.stream()
                .map(mapper::toDto)
                .toList();
    }

    public VehicleResponseDto findById(UUID id){
        Vehicle vehicle = findEntityById(id);

        return mapper.toDto(vehicle);
    }

    public Vehicle findEntityById(UUID id){
        Objects.requireNonNull(id, "O id não pode ser nulo.");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado."));
    }

    public VehicleResponseDto findByInternalCode(String internalCode){

        Vehicle vehicle = findEntityByInternalCode(internalCode);

        return mapper.toDto(vehicle);
    }

    public Vehicle findEntityByInternalCode(String internalCode){

        Objects.requireNonNull(internalCode, "O código interno não pode ser nulo.");

        return repository.findByInternalCode(internalCode).orElseThrow(() -> new ResourceNotFoundException(String.format("Não foi encontrado nenhum veiculo com o código interno: %s.", internalCode)));
    }

    public List<VehicleResponseDto> findByStatus(VehicleStatus status){

        List<Vehicle> vehicleList = repository.findByStatus(status);

        return vehicleList.stream()
                .map(mapper::toDto)
                .toList();
    }

    public VehicleResponseDto findByLicensePlate(String license){


        if(license == null || !PT_LICENSE_PLATE_PATTERN.matcher(license).matches()){
            throw new BusinessException("Formato de matrícula inválido. Use o padrão AA-00-00, 00-AA-00 ou AA-BB-00.");
        }

        Vehicle vehicle = repository.findByLicensePlate(license).orElseThrow(() -> new ResourceNotFoundException(String.format("Veiculo de matricula %s não encontrado.", license)));

        return mapper.toDto(vehicle);
    }

    public List<VehicleResponseDto> findByVehicleType(VehicleType type){
        List<Vehicle> vehiclesList = repository.findByVehicleType(type);

        return vehiclesList.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<VehicleResponseDto> findByBrand(String brand){
        List<Vehicle> vehiclesList = repository.findByBrand(brand);

        return vehiclesList.stream()
                .map(mapper::toDto)
                .toList();
    }


    public VehicleResponseDto create(VehicleCreateDto request){
        Vehicle vehicle = mapper.toEntity(request);
        Vehicle saved = repository.save(vehicle);

        return mapper.toDto(saved);
    }

    @Transactional
    public VehicleResponseDto update(VehicleCreateDto request, UUID id){
        Objects.requireNonNull(id,"O id não pode ser nulo.");
        Objects.requireNonNull(request, "O veiculo não pode ser nulo.");

        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado."));

        mapper.updateEntityFromDto(request, vehicle);

        repository.save(vehicle);

        return mapper.toDto(vehicle);
    }








}
