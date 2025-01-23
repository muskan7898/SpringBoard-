package com.example.spring.board.services.core;

import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.repository.MaintenanceScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceScheduleCoreService {
    private final MaintenanceScheduleRepository maintenanceScheduleRepository;

    public MaintenanceSchedule saveSchedule(MaintenanceSchedule schedule){
        try{
            return maintenanceScheduleRepository.save(schedule);
        } catch (Exception e) {
            System.out.println("some error while saving schedule: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public MaintenanceSchedule getScheduleByIdAndVehicleId(Long id, Long vehicleId){
        try{
           return maintenanceScheduleRepository.findByIdAndVehicleId(id, vehicleId).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteScheduleByVehicleId(Long vehicleId){
        try{
            maintenanceScheduleRepository.deleteByVehicleId(vehicleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MaintenanceSchedule updateScheduleById(Long id, MaintenanceSchedule updatedSchedule){
        try{
            MaintenanceSchedule existingSchedule = maintenanceScheduleRepository.findById(id)
                    .orElseThrow(() ->
                            new EntityNotFoundException("Maintenance schedule not found for ID: " + id)
                    );

            existingSchedule.setServiceDate(updatedSchedule.getServiceDate());
            existingSchedule.setServiceDetail(updatedSchedule.getServiceDetail());
            return maintenanceScheduleRepository.save(existingSchedule);
        } catch (Exception e) {
            System.out.println("error while updating schedule: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteScheduleById(Long id){
        try {
            MaintenanceSchedule existingSchedule = maintenanceScheduleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Maintenance schedule not found for ID: " + id));
            maintenanceScheduleRepository.delete(existingSchedule);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaintenanceSchedule> getScheduleByVehicleId(Long vehicleId){
        try{
            return maintenanceScheduleRepository.findAllByVehicleId(vehicleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
