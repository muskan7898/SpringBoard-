package com.example.spring.board.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehicle {
    private String model;
    private int manufactureYear;
    private String status;
    private Long typeId;
}
