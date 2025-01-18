package com.example.spring.board.controller;

import com.example.spring.board.dto.res.MaintenanceScheduleDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maintenance-schedule")
public class MaintenanceScheduleController {

    @PostMapping("/create")
    public String insertMaintenanceSchedule(){
        return "";
    }


    @PutMapping("/update-schedule/{vehicleId}")
    public String updateMaintenanceById(@PathVariable String vehicleId){
        return "";
    }

    @DeleteMapping("/delete-schedule/{vehicleId}")
    public String deleteMaintenanceById(@PathVariable String vehicleId){
        return "";
    }


    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceScheduleDetail> getMaintenanceScheduleById(@PathVariable Long id) {
//        return ResponseEntity.ok(maintenanceScheduleService.getMaintenanceScheduleById(id));
        return null;
    }

    @GetMapping("/by-vehicle/{vehicleId}")
    public List<MaintenanceScheduleDetail> getSchedulesByVehicle(@PathVariable Long vehicleId) {
//        return maintenanceScheduleService.getSchedulesByVehicle(vehicleId);
        return null;
    }

}
