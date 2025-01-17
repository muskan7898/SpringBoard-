package com.example.spring.board.dto.req;

import com.example.spring.board.enums.VehicleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleStatus {
    private Long id;

    @NotNull(message = "vehicle status should not be null")
    @Enumerated(EnumType.STRING)
    private VehicleStatus newStatus;
}


