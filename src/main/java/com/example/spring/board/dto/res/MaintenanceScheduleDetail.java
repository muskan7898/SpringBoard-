package com.example.spring.board.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceScheduleDetail {
    private Long id;
    private Long vehicleId;
    private String serviceDate;
    private String serviceDetail;
}

