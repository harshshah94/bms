package com.intuit.bms.service;

import com.intuit.bms.model.Cinema;
import com.intuit.bms.model.Show;
import com.intuit.bms.repository.CinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CinemaService {

    @Autowired CinemaRepository cinemaRepository;

    public Cinema addCinema(Cinema cinema) {

        return null;
    }

    public List<Show> getMovieShows(Integer id) {

        return null;
    }
}
