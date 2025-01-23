package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateMaintenanceSchedule;
import com.example.spring.board.dto.req.UpdateVehicleMaintenanceSchedule;
import com.example.spring.board.dto.res.MaintenanceScheduleDetail;
import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.services.core.MaintenanceScheduleCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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

    public String updateScheduleService(Long vehicleId, Long id, UpdateVehicleMaintenanceSchedule schedule){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleByIdAndVehicleId(id, vehicleId);
        System.out.println(maintenanceSchedule);
        maintenanceSchedule.setServiceDetail(schedule.getServiceDetail());

        maintenanceScheduleCoreService.saveSchedule(maintenanceSchedule);
        return maintenanceSchedule.getId().toString();
    }

    public void deleteScheduleByVehicleIdService(Long vehicleId, Long id){
        maintenanceScheduleCoreService.deleteScheduleByVehicleId(vehicleId, id);
    }


    public MaintenanceScheduleDetail getScheduleByIdService(Long id){
        MaintenanceSchedule maintenanceSchedule = maintenanceScheduleCoreService.getScheduleById(id);
        if(maintenanceSchedule == null){
            throw new EntityNotFoundException("schedule is not exist for this id: " + id);
        }

        MaintenanceScheduleDetail maintenanceScheduleDetail = new MaintenanceScheduleDetail();
        maintenanceScheduleDetail.setId(maintenanceSchedule.getId());
        maintenanceScheduleDetail.setServiceDetail(maintenanceSchedule.getServiceDetail());
        maintenanceScheduleDetail.setServiceDate(maintenanceSchedule.getServiceDate());
        maintenanceScheduleDetail.setVehicleId(maintenanceSchedule.getVehicleId());

        return maintenanceScheduleDetail;
    }

    public List<MaintenanceScheduleDetail> getByVehicleIdService(Long vehicleId){
        List<MaintenanceSchedule> maintenanceSchedules =  maintenanceScheduleCoreService.getScheduleByVehicleId(vehicleId);

        List<MaintenanceScheduleDetail> maintenanceScheduleDetails = new ArrayList<>();

        for(MaintenanceSchedule m : maintenanceSchedules){
            MaintenanceScheduleDetail maintenanceScheduleDetail = new MaintenanceScheduleDetail();
            maintenanceScheduleDetail.setId(m.getId());
            maintenanceScheduleDetail.setServiceDetail(m.getServiceDetail());
            maintenanceScheduleDetail.setServiceDate(m.getServiceDate());
            maintenanceScheduleDetail.setVehicleId(m.getVehicleId());

            maintenanceScheduleDetails.add(maintenanceScheduleDetail);
        }

        return maintenanceScheduleDetails;
    }

}
