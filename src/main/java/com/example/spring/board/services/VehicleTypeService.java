package com.example.spring.board.services;

import com.example.spring.board.model.VehicleType;
import com.example.spring.board.repository.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;


    public VehicleType saveVehicleType(VehicleType vehicleType){
        return null;
    }

    public List<VehicleType> getAll(){
        return null;
    }

    public VehicleType getById(Long id){
        return null;
    }

    public void deleteById(Long id){

    }

}
