package com.example.spring.board.repository;

import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
     List<Vehicle> findAllByStatus(VehicleStatus status);

//     @Query("SELECT v.name, vt.typeName FROM Vehicle v " +
//             "LEFT JOIN VehicleType vt ON v.typeId = vt.id")
//     List<Object[]> findVehicleWithVehicleType();

     @Query(value = """
    SELECT v.model, v.manufacture_year, v.status, v.type_id, 
           b.start_date, b.end_date 
    FROM vehicle v 
    LEFT JOIN vehicle_booking vb ON v.id = vb.vehicle_id 
    LEFT JOIN booking b ON vb.booking_id = b.id
    WHERE v.id = :vehicleId
    """, nativeQuery = true)
     List<Object[]> findBookingDetailsByVehicleId(@Param("vehicleId") Long vehicleId);

}
