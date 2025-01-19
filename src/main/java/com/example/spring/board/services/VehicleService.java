package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleDetail;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public Vehicle updateVehicleStatus(Long id, Vehicle updatedVehicle){
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + id));
        existingVehicle.setStatus(updatedVehicle.getStatus());
        return vehicleRepository.save(existingVehicle);
    }

    public List<Vehicle> getAvailableVehicle(){
        return null;
    }

    public Vehicle getVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if(vehicle == null){
            return null;
        }
        return vehicle;
    }

    public void deleteVehicle(Long id){
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found with ID: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getVehicleByStatus(String status){
        return null;
    }

}
