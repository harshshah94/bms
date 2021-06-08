package com.intuit.bms.service;

import com.intuit.bms.repository.CinemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CinemaServiceTest {

    @Mock
    CinemaRepository cinemaRepository;

    CinemaService cinemaService;

    @BeforeEach
    void setUp() {
        this.cinemaService = new CinemaService(cinemaRepository);
    }


}