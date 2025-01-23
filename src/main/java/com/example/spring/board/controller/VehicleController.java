package com.example.spring.board.controller;

import com.example.spring.board.dto.req.CreateVehicle;
import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.dto.res.VehicleDetail;
import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<String> insertVehicle(@RequestBody CreateVehicle createVehicle){
        return ResponseEntity.ok(vehicleService.insertVehicleService(createVehicle));
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateVehicleStatus(@RequestBody @Valid UpdateVehicleStatus updateVehicleStatus, @PathVariable Long id){
        return ResponseEntity.ok(vehicleService.updateVehicleStatusService(updateVehicleStatus, id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<VehicleDetail>> getAllVehicle(){
        return vehicleService.getAllVehicleService();
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<VehicleDetail> getVehicleById(@PathVariable Long id){
        return vehicleService.getVehicleByIdService(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Long id){
        vehicleService.deleteVehicleByService(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<VehicleDetail>> getVehiclesByStatus(@PathVariable VehicleStatus status) {
        return vehicleService.getVehicleByStatusService(status);
    }

}
