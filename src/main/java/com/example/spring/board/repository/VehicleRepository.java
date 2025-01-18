package com.example.spring.board.repository;

import com.example.spring.board.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
