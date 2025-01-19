package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class VehicleTypeService {
    private VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleTypeService(@RequestBody VehicleTypeDetail vehicleTypeDetail){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName(vehicleTypeDetail.getType());
        VehicleType savedVehicleType = vehicleTypeCoreService.saveVehicleType(vehicleType);
        return savedVehicleType.getId().toString();
    }

    public ResponseEntity<VehicleTypeDetail> getVehicleByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);
        VehicleTypeDetail vehicleTypeDetail = new VehicleTypeDetail();
        vehicleTypeDetail.setTypeId(vehicleType.getId());
        vehicleTypeDetail.setType(vehicleType.getTypeName());
        return ResponseEntity.ok(vehicleTypeDetail);
    }

    public void deleteVehicleTypeByIdService(Long id){
        vehicleTypeCoreService.deleteVehicleTypeById(id);
    }

    public ResponseEntity<List<VehicleTypeDetail>> getAllVehicleTypeService(){
        List<VehicleType> vehicleTypes = vehicleTypeCoreService.getAllVehicleTypes();
        List<VehicleTypeDetail> vehicleTypeDetails = new ArrayList<>();

        // have to complete this
        return ResponseEntity.ok(vehicleTypeDetails);
    }

}
