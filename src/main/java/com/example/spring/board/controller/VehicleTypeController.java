package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.VehicleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    private final VehicleTypeService vehicleTypeService;
    @PostMapping()
    public ResponseEntity<String> insertVehicleType(@RequestBody @Valid VehicleTypeDetail vehicleTypeDetail){
        try{
            return ResponseEntity.ok(vehicleTypeService.insertVehicleTypeService(vehicleTypeDetail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleTypeById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(vehicleTypeService.getVehicleByIdService(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleType(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(vehicleTypeService.deleteVehicleTypeByIdService(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());

        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllVehicleType(){
        try {
            return ResponseEntity.ok(vehicleTypeService.getAllVehicleTypeService());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
