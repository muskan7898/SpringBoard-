package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    @PostMapping("/create")
    public String insertVehicleType(@RequestBody @Valid VehicleTypeDetail vehicleTypeDetail){
        return "";
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeDetail> getVehicleTypeById(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteVehicleType(@PathVariable Long id) {
        return null;
    }

    @GetMapping("get-all")
    public List<VehicleTypeDetail> getAllVehicleType(){
        return null;
    }
}
