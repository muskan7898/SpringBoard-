package com.example.spring.board.services.core;

import com.example.spring.board.model.VehicleType;
import com.example.spring.board.repository.VehicleTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeCoreService {
    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleType saveVehicleType(VehicleType vehicleType){
        try{
            return vehicleTypeRepository.save(vehicleType);
        } catch (Exception e) {
            System.out.println("error while saving vehicle type: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<VehicleType> getAllVehicleTypes()
    {
        try{
            return vehicleTypeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public VehicleType getVehicleTypeById(Long id){
        try{
            return vehicleTypeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteVehicleTypeById(Long id){
        try {
            VehicleType vehicleType =  vehicleTypeRepository.findById(id).orElse(null);
            if(vehicleType == null){
                throw new EntityNotFoundException("VehicleType not found for id: " + id);
            }
            vehicleTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
