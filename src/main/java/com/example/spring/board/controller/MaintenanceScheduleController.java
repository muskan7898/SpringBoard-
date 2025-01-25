package com.example.spring.board.controller;

import com.example.spring.board.dto.req.CreateMaintenanceSchedule;
import com.example.spring.board.dto.req.UpdateVehicleMaintenanceSchedule;
import com.example.spring.board.dto.res.MaintenanceScheduleDetail;
import com.example.spring.board.model.MaintenanceSchedule;
import com.example.spring.board.services.MaintenanceScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try{
            return ResponseEntity.ok(maintenanceScheduleService.insertScheduleService(createMaintenanceSchedule));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping("/{vehicleId}/{id}")
    public ResponseEntity<String> updateMaintenanceById(@PathVariable Long vehicleId, @PathVariable Long id, @RequestBody UpdateVehicleMaintenanceSchedule updateVehicleMaintenanceSchedule){
        try{
            return ResponseEntity.ok(maintenanceScheduleService.updateScheduleService(vehicleId, id, updateVehicleMaintenanceSchedule));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    //testing is not done for this, having issues
    @DeleteMapping("/{vehicleId}/{id}")
    public ResponseEntity<?> deleteMaintenanceById(@PathVariable Long vehicleId, @PathVariable Long id){
        try{
            return maintenanceScheduleService.deleteScheduleByVehicleIdService(vehicleId, id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceScheduleById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(maintenanceScheduleService.getScheduleByIdService(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> getSchedulesByVehicle(@PathVariable Long vehicleId) {
        try{
            return ResponseEntity.ok(maintenanceScheduleService.getByVehicleIdService(vehicleId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
