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
        return maintenanceScheduleRepository.save(schedule);
    }

    public MaintenanceSchedule updateById(Long id, MaintenanceSchedule updatedSchedule){
        MaintenanceSchedule existingSchedule = maintenanceScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance schedule not found for ID: " + id));

        existingSchedule.setServiceDate(updatedSchedule.getServiceDate());
        existingSchedule.setServiceDetail(updatedSchedule.getServiceDetail());
        return maintenanceScheduleRepository.save(existingSchedule);
    }

    public void deleteById(Long id){
        MaintenanceSchedule existingSchedule = maintenanceScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance schedule not found for ID: " + id));
        maintenanceScheduleRepository.delete(existingSchedule);
    }

    public List<MaintenanceSchedule> getByVehicleId(Long vehicleId){
        return null;
    }

}
