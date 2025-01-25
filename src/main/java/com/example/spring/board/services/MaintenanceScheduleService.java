package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateMaintenanceSchedule;
import com.example.spring.board.dto.req.UpdateVehicleMaintenanceSchedule;
import com.example.spring.board.dto.res.MaintenanceScheduleDetail;
import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.services.core.MaintenanceScheduleCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceScheduleService {
    private final MaintenanceScheduleCoreService maintenanceScheduleCoreService;

    public String insertScheduleService(@RequestBody CreateMaintenanceSchedule createMaintenanceSchedule){
        MaintenanceSchedule maintenanceSchedule = MaintenanceSchedule.builder()
                .serviceDate(createMaintenanceSchedule.getServiceDate())
                .serviceDetail(createMaintenanceSchedule.getServiceDetail())
                .vehicleId(createMaintenanceSchedule.getVehicleId())
                .build();

        MaintenanceSchedule savedSchedule = maintenanceScheduleCoreService.saveSchedule(maintenanceSchedule);
        return savedSchedule.getId().toString();
    }

    public String updateScheduleService(Long vehicleId, Long id, UpdateVehicleMaintenanceSchedule schedule){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleByIdAndVehicleId(id, vehicleId);
        maintenanceSchedule.setServiceDetail(schedule.getServiceDetail());
        maintenanceScheduleCoreService.saveSchedule(maintenanceSchedule);
        return maintenanceSchedule.getId().toString();
    }

    public ResponseEntity<MaintenanceSchedule> deleteScheduleByVehicleIdService(Long vehicleId, Long id){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleByIdAndVehicleId(id, vehicleId);
        if(maintenanceSchedule == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if booking doesn't exist
        }

        maintenanceScheduleCoreService.deleteScheduleByVehicleId(vehicleId, id);
        return ResponseEntity.ok(maintenanceSchedule);
    }


    public MaintenanceScheduleDetail getScheduleByIdService(Long id){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleById(id);
        if(maintenanceSchedule == null){
            throw new EntityNotFoundException("schedule is not exist for this id: " + id);
        }

        return new MaintenanceScheduleDetail(
                maintenanceSchedule.getId(),
                maintenanceSchedule.getVehicleId(),
                maintenanceSchedule.getServiceDate(),
                maintenanceSchedule.getServiceDetail()
        );
    }

    public List<MaintenanceScheduleDetail> getByVehicleIdService(Long vehicleId){
        List<MaintenanceSchedule> maintenanceSchedules =  maintenanceScheduleCoreService.getScheduleByVehicleId(vehicleId);

        List<MaintenanceScheduleDetail> maintenanceScheduleDetails = new ArrayList<>();

        for(MaintenanceSchedule m : maintenanceSchedules){
            maintenanceScheduleDetails.add(new MaintenanceScheduleDetail(
                    m.getId(),
                    m.getVehicleId(),
                    m.getServiceDate(),
                    m.getServiceDetail()
            ));
        }
        return maintenanceScheduleDetails;
    }

}
