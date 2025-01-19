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
    private VehicleTypeService vehicleTypeService;
    @PostMapping("/create")
    public String insertVehicleType(@RequestBody @Valid VehicleTypeDetail vehicleTypeDetail){
        return vehicleTypeService.insertVehicleTypeService(vehicleTypeDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeDetail> getVehicleTypeById(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.deleteVehicleTypeByIdService(id);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<VehicleTypeDetail>> getAllVehicleType(){
        return vehicleTypeService.getAllVehicleTypeService();
    }
}
