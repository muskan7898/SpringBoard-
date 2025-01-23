package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleTypeService(@RequestBody VehicleTypeDetail vehicleTypeDetail){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName(vehicleTypeDetail.getType());
        VehicleType savedVehicleType = vehicleTypeCoreService.saveVehicleType(vehicleType);
        return savedVehicleType.getId().toString();
    }

    public VehicleTypeDetail getVehicleByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);
        VehicleTypeDetail vehicleTypeDetail = new VehicleTypeDetail();
        vehicleTypeDetail.setTypeId(vehicleType.getId());
        vehicleTypeDetail.setType(vehicleType.getTypeName());
        return vehicleTypeDetail;
    }


    public void deleteVehicleTypeByIdService(Long id){
        vehicleTypeCoreService.deleteVehicleTypeById(id);
    }

    public ResponseEntity<List<VehicleTypeDetail>> getAllVehicleTypeService(){
        List<VehicleType> vehicleTypes = vehicleTypeCoreService.getAllVehicleTypes();
        List<VehicleTypeDetail> vehicleTypeDetails = new ArrayList<>();

        for(VehicleType vt : vehicleTypes){
            VehicleTypeDetail vehicleTypeDetail = new VehicleTypeDetail();
            vehicleTypeDetail.setTypeId(vt.getId());
            vehicleTypeDetail.setType(vt.getTypeName());

            vehicleTypeDetails.add(vehicleTypeDetail);
        }

        return ResponseEntity.ok(vehicleTypeDetails);
    }

}
