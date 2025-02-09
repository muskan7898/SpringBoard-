package com.example.spring.board.services.provider;

import com.example.spring.board.enums.UtilsType;
import com.example.spring.board.interfaces.UtilsInterface;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UtilsProvider {
    private final Map<UtilsType, UtilsInterface> utilsMap = new HashMap<>();

    public UtilsProvider(List<UtilsInterface> utilsInterfaces) {
        utilsInterfaces.forEach(utilsInterface -> {
            utilsMap.put(utilsInterface.getUtilsType(), utilsInterface);
        });
    }

    public UtilsInterface getUtilsInterface(UtilsType utilsType) {
        UtilsInterface utilsInterface = utilsMap.getOrDefault(utilsType, null);
        if(utilsInterface == null) {
            throw new IllegalStateException(utilsType.toString() + " does not exists");
        }

        return utilsInterface;
    }
}
