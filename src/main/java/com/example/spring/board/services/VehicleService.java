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

    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle){
        return null;
    }

    public List<Vehicle> getAllVehicle(){
        return null;
    }

    public Vehicle updateVehicleStatus(Long id, Vehicle updatedVehicle){
        return null;
    }

    public List<Vehicle> getAvailableVehicle(){
        return null;
    }

    public Vehicle getVehicleById(Long id){
        return null;
    }

    public void deleteVehicle(Long id){

    }

    public List<Vehicle> getVehicleByStatus(String status){
        return null;
    }


}
