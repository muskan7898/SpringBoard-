package com.example.spring.board.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateMaintenanceSchedule {
    private Long vehicleId;
    private String serviceDate;
    private String serviceDetail;
}

