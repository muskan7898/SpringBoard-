package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateMaintenanceSchedule;
import com.example.spring.board.dto.req.UpdateVehicleMaintenanceSchedule;
import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.services.core.MaintenanceScheduleCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceScheduleService {
    private final MaintenanceScheduleCoreService maintenanceScheduleCoreService;

    public String insertScheduleService(@RequestBody CreateMaintenanceSchedule createMaintenanceSchedule){
        MaintenanceSchedule maintenanceSchedule = new MaintenanceSchedule();

        maintenanceSchedule.setServiceDetail(createMaintenanceSchedule.getServiceDetail());
        maintenanceSchedule.setServiceDate(createMaintenanceSchedule.getServiceDate());
        maintenanceSchedule.setVehicleId(createMaintenanceSchedule.getVehicleId());

        MaintenanceSchedule savedSchedule = maintenanceScheduleCoreService.saveSchedule(maintenanceSchedule);
        return savedSchedule.getId().toString();
    }

    public String   updateScheduleService(Long vehicleId, Long id, UpdateVehicleMaintenanceSchedule schedule){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleByIdAndVehicleId(id, vehicleId);
        System.out.println(maintenanceSchedule);
        maintenanceSchedule.setServiceDetail(schedule.getServiceDetail());

        maintenanceScheduleCoreService.saveSchedule(maintenanceSchedule);
        return maintenanceSchedule.getId().toString();
    }

    public void deleteScheduleByVehicleIdService(Long vehicleId){
        maintenanceScheduleCoreService.deleteScheduleByVehicleId(vehicleId);
    }
}
