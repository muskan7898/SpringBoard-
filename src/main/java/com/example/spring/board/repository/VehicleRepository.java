package com.example.spring.board.repository;

import com.example.spring.board.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
     List<Vehicle> findAllByStatus(Enum status);
     List<Vehicle> findAllAvailable(String status);
}
