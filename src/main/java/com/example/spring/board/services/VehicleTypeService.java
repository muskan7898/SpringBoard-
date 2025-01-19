package com.example.spring.board.services;

import com.example.spring.board.model.VehicleType;
import com.example.spring.board.repository.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;


    public VehicleType createVehicleType(VehicleType vehicleType){
        return vehicleTypeRepository.save(vehicleType);
    }

    public List<VehicleType> getAllVehicleTypes()
    {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType getVehicleTypeById(Long id){
        VehicleType vehicleType =  vehicleTypeRepository.findById(id).orElse(null);
        if(vehicleType == null){
            throw new RuntimeException("VehicleType not found for id: " + id);
        }
        return vehicleType;
    }

    public void deleteById(Long id){
        VehicleType vehicleType =  vehicleTypeRepository.findById(id).orElse(null);
        if(vehicleType == null){
            throw new RuntimeException("VehicleType not found for id: " + id);
        }
        vehicleTypeRepository.deleteById(id);
    }

}
