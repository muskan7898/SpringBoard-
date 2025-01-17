package com.example.spring.board.dto.req;

import com.example.spring.board.enums.VehicleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
