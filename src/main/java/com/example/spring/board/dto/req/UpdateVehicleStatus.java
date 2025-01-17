package com.example.spring.board.dto.req;

import com.example.spring.board.enums.VehicleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleStatus {
    private Long id;

    @NotNull(message = "vehicle status should not be null")
    @Enumerated(EnumType.STRING)
    private VehicleStatus newStatus;
}


