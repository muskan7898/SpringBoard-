package com.example.spring.board.dto.req;

import com.example.spring.board.enums.VehicleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehicle {

    private String model;
    private int manufactureYear;
    @Enumerated(EnumType.STRING)

    @NotNull(message = "status should not be null")
    private VehicleStatus status;
    private Long typeId;
}
