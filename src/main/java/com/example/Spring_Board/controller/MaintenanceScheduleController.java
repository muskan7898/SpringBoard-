package com.example.Spring_Board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


}
