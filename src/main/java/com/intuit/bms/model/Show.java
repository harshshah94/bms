package com.intuit.bms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Show {

    @Id
    @GeneratedValue
    private Integer showId;
    private LocalDate createdOn;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaHallId")
    private CinemaHall playedAt;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Show() {}

    public Show(LocalDate createdOn, LocalDateTime startTime, LocalDateTime endTime) {
        this.createdOn = createdOn;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
