package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import com.example.spring.board.services.VehicleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    private final VehicleTypeService vehicleTypeService;
    @PostMapping("/create")
    public ResponseEntity<String> insertVehicleType(@RequestBody @Valid VehicleTypeDetail vehicleTypeDetail){
        return ResponseEntity.ok(vehicleTypeService.insertVehicleTypeService(vehicleTypeDetail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeDetail> getVehicleTypeById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleTypeService.getVehicleByIdService(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.deleteVehicleTypeByIdService(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get-all")
    public ResponseEntity<List<VehicleTypeDetail>> getAllVehicleType(){
        return vehicleTypeService.getAllVehicleTypeService();
    }
}
