package com.example.Spring_Board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maintenance-schedule")
public class MaintenanceScheduleController {

    @PostMapping("/create")
    public String insertMaintenanceSchedule(){
        return "";
    }

}
