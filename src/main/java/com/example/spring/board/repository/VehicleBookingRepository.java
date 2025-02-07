package com.example.spring.board.repository;

import com.example.spring.board.model.VehicleBooking;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleBookingRepository extends JpaRepository<VehicleBooking, Long>{

}
