package com.example.spring.board.dto.req;

import com.example.spring.board.general.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehicle {
    private String model;
    private int manufactureYear;
    private VehicleStatus status;
    private Long typeId;
}
