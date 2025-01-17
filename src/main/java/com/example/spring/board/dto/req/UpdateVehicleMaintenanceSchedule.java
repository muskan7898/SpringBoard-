package com.example.spring.board.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVehicleMaintenanceSchedule {
    @NotNull(message = "service detail should have to provide")
    private String serviceDetail;
}

