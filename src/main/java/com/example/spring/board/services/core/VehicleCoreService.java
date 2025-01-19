package com.example.spring.board.services.core;

import com.example.spring.board.model.Vehicle;
import com.example.spring.board.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleCoreService {

    private final VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle){
        try{
            return vehicleRepository.save(vehicle);
        } catch (Exception e) {
            System.out.println("error while saving vehicle");
            throw new RuntimeException(e);
        }
    }

    public List<Vehicle> getAllVehicle(){
        try{
            return vehicleRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Vehicle> getAvailableVehicle(){
        try {
            return vehicleRepository.findAllAvailable("Available");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Vehicle getVehicleById(Long id){
        try{
            Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
            if(vehicle == null){
                throw new EntityNotFoundException("vehicle not found for this id: " + id);
            }
            return vehicle;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteVehicle(Long id){
        try{
            if (!vehicleRepository.existsById(id)) {
                throw new EntityNotFoundException("Vehicle not found with ID: " + id);
            }
            vehicleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vehicle> getVehicleByStatus(Enum status){
        try {
            return vehicleRepository.findAllByStatus(status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
