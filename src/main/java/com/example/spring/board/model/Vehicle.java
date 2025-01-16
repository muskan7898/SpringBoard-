package com.example.spring.board.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private int manufactureYear;

//    available, booked, maintenance
    private String status;

    @Column(nullable = false)
    private Long typeId;
}
