package com.example.spring.board.repository;

import com.example.spring.board.model.MaintenanceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceScheduleRepository extends JpaRepository<MaintenanceSchedule, Long>{
    List<MaintenanceSchedule> findAllByVehicleId(Long VehicleId);
}
