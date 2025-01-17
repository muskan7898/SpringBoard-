package com.example.spring.board.controller;

import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.dto.res.VehicleDetail;
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
    @PostMapping("/create")
    public String insertVehicle(@RequestBody VehicleDetail vehicleDetail){
        return "";
    }

    @PutMapping("/update-status")
    public String updateVehicleStatus(@RequestBody @Valid UpdateVehicleStatus updateVehicleStatus){
        return "";
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<VehicleDetail>> getAllVehicle(){
        return null;
    }

    @GetMapping("/get-available-vehicle")
    public ResponseEntity<List<VehicleDetail>> getAvailableVehicle(){
        return null;
    }

    @GetMapping("/getById/{Id}")
    public VehicleDetail getVehicleById(@PathVariable String Id){
        return null;
    }

    @DeleteMapping("/delete/{Id}")
    public String deleteVehicleById(@PathVariable String Id){
        return null;
    }

    @GetMapping("/by-status/{status}")
    public List<VehicleDetail> getVehiclesByStatus(@PathVariable String status) {
        return null;
    }

}
