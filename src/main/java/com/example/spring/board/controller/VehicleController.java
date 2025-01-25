package com.example.spring.board.controller;

import com.example.spring.board.dto.req.CreateVehicle;
import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    @PostMapping("/create")
    public ResponseEntity<String> insertVehicle(@RequestBody @Valid CreateVehicle createVehicle){
        try{
            return ResponseEntity.ok(vehicleService.insertVehicleService(createVehicle));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicleStatus(@RequestBody @Valid UpdateVehicleStatus updateVehicleStatus, @PathVariable Long id){
        try{
            return ResponseEntity.ok(vehicleService.updateVehicleStatusService(updateVehicleStatus, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllVehicle(){
        try{
            return vehicleService.getAllVehicleService();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id){
        try{
            return vehicleService.getVehicleByIdService(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable Long id){
        try{
            return vehicleService.deleteVehicleByService(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }

    @GetMapping("/by-status")
    public ResponseEntity<?> getVehiclesByStatus(@RequestParam("status") VehicleStatus status) {
        try{
            return vehicleService.getVehicleByStatusService(status);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
