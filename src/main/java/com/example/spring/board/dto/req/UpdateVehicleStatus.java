package com.example.spring.board.dto.req;

import com.example.spring.board.general.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleStatus {
    private Long id;
    private VehicleStatus newStatus;
}


