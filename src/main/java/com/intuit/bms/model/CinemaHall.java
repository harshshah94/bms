package com.intuit.bms.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CinemaHall {

    @Id
    @GeneratedValue
    private Integer cinemaHallId;
    private Integer cinemaHallSeats;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cinema cinema;

    @OneToMany(mappedBy = "playedAt")
    List<Show> movieShows = new ArrayList<>();
}
