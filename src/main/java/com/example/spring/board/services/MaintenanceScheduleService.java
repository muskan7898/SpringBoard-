package com.example.spring.board.services;

import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.repository.MaintenanceScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceScheduleService {
    private final MaintenanceScheduleRepository maintenanceScheduleRepository;

    public MaintenanceSchedule savaSchedule(MaintenanceSchedule schedule){
        return null;
    }

    public MaintenanceSchedule updateByVehicleId(Long vehicleId, MaintenanceSchedule updatedSchedule){
        return null;
    }

    public void deleteByVehicleId(Long vehicleId){

    }
    public List<MaintenanceSchedule> getByVehicleId(Long vehicleId){
        return null;
    }

}
