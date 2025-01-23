package com.example.spring.board.controller;

import com.example.spring.board.dto.req.CreateMaintenanceSchedule;
import com.example.spring.board.dto.req.UpdateVehicleMaintenanceSchedule;
import com.example.spring.board.dto.res.MaintenanceScheduleDetail;
import com.example.spring.board.services.MaintenanceScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maintenance-schedule")
public class MaintenanceScheduleController {

    private final MaintenanceScheduleService maintenanceScheduleService;

    @PostMapping("/create")
    public ResponseEntity<String> insertMaintenanceSchedule(@RequestBody @Valid CreateMaintenanceSchedule createMaintenanceSchedule){
        return ResponseEntity.ok(maintenanceScheduleService.insertScheduleService(createMaintenanceSchedule));
    }


    @PutMapping("/update-schedule/{vehicleId}/{id}")
    public ResponseEntity<String> updateMaintenanceById(@PathVariable Long vehicleId, @PathVariable Long id, @RequestBody UpdateVehicleMaintenanceSchedule updateVehicleMaintenanceSchedule){
        return ResponseEntity.ok(maintenanceScheduleService.updateScheduleService(vehicleId, id, updateVehicleMaintenanceSchedule));
    }

    @DeleteMapping("/delete-schedule/{vehicleId}")
    public ResponseEntity<Void> deleteMaintenanceById(@PathVariable Long vehicleId){
        maintenanceScheduleService.deleteScheduleByVehicleIdService(vehicleId);
        return ResponseEntity.ok().build();
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
