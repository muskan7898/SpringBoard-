package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateVehicle;
import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.dto.res.VehicleDetail;
import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.core.VehicleCoreService;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleCoreService vehicleCoreService;
    private final VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleService(@RequestBody CreateVehicle createVehicle){
        Vehicle vehicle = new Vehicle();

        vehicle.setStatus(createVehicle.getStatus());
        vehicle.setManufactureYear(createVehicle.getManufactureYear());
        vehicle.setModel(createVehicle.getModel());
        vehicle.setTypeId(createVehicle.getTypeId());
        Vehicle savedVehicle = vehicleCoreService.saveVehicle(vehicle);

        return savedVehicle.getId().toString();
    }

    public String updateVehicleStatusService(@RequestBody UpdateVehicleStatus updateVehicleStatus, @PathVariable Long id){
        try {
            Vehicle existingVehicle = vehicleCoreService.getVehicleById(id);
            existingVehicle.setStatus(updateVehicleStatus.getNewStatus());
            vehicleCoreService.saveVehicle(existingVehicle);
            return id.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<VehicleDetail>> getAllVehicleService() {
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        List<Vehicle> vehicles = vehicleCoreService.getAllVehicle();

        if (vehicles == null || vehicles.isEmpty()) {
            return ResponseEntity.ok(vehicleDetails);
        }

        for (Vehicle v : vehicles) {
            if (v == null) continue;

            VehicleDetail v1 = new VehicleDetail();
            v1.setManufactureYear(v.getManufactureYear());
            v1.setVehicleId(v.getId());
            v1.setModel(v.getModel());
            v1.setStatus(v.getStatus() != null ? v.getStatus().toString() : "UNKNOWN");

            VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
            if (vehicleType != null) {
                v1.setTypeName(vehicleType.getTypeName());
            } else {
                v1.setTypeName(null);
            }
            vehicleDetails.add(v1);
        }
        return ResponseEntity.ok(vehicleDetails);
    }

    public ResponseEntity<VehicleDetail> getVehicleByIdService(Long id) {
        Vehicle vehicle = vehicleCoreService.getVehicleById(id);

        if (vehicle == null) {
            return ResponseEntity.notFound().build(); // Return 404 if no vehicle is found
        }

        VehicleDetail vehicleDetail = new VehicleDetail();
        vehicleDetail.setVehicleId(vehicle.getId());
        vehicleDetail.setModel(vehicle.getModel());
        vehicleDetail.setStatus(vehicle.getStatus() != null ? vehicle.getStatus().toString() : "UNKNOWN");
        vehicleDetail.setManufactureYear(vehicle.getManufactureYear());

        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(vehicle.getTypeId());
        if (vehicleType != null) {
            vehicleDetail.setTypeName(vehicleType.getTypeName());
        } else {
            vehicleDetail.setTypeName(null);
        }

        return ResponseEntity.ok(vehicleDetail);
    }

    public void deleteVehicleByService(Long id){
        vehicleCoreService.deleteVehicle(id);
    }

    public ResponseEntity<List<VehicleDetail>> getVehicleByStatusService(VehicleStatus status){
        List<Vehicle> vehicles = vehicleCoreService.getVehicleByStatus(status);
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        if (vehicles == null || vehicles.isEmpty()) {
            return ResponseEntity.ok(vehicleDetails);
        }

        for (Vehicle v : vehicles) {
            if (v == null) continue;

            VehicleDetail v1 = new VehicleDetail();
            v1.setManufactureYear(v.getManufactureYear());
            v1.setVehicleId(v.getId());
            v1.setModel(v.getModel());
            v1.setStatus(v.getStatus() != null ? v.getStatus().toString() : "UNKNOWN");

            VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
            if (vehicleType != null) {
                v1.setTypeName(vehicleType.getTypeName());
            } else {
                v1.setTypeName(null);
            }
            vehicleDetails.add(v1);
        }
        return ResponseEntity.ok(vehicleDetails);
    }
}
