package com.example.spring.board.services;

import com.example.spring.board.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
}
