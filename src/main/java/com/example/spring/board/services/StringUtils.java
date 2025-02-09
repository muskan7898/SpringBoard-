package com.example.spring.board.services;

import com.example.spring.board.enums.UtilsType;
import com.example.spring.board.interfaces.UtilsInterface;
import org.springframework.stereotype.Service;

@Service
public class StringUtils implements UtilsInterface {
    @Override
    public UtilsType getUtilsType() {
        return UtilsType.STRING_UTILS;
    }

    @Override
    public void perform() {
        System.out.println("this is from the string utils");
    }
}
