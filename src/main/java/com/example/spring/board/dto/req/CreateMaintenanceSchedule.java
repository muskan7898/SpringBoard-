package com.example.spring.board.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateMaintenanceSchedule {
    @NotNull(message = "vehicle id have to provide")
    private Long vehicleId;
    private String serviceDate;

    @NotNull(message = "service detail should be provided")
    private String serviceDetail;
}

