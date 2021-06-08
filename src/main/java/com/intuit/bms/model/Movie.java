package com.intuit.bms.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long movieId;
    @Column
    @NotBlank(message = "Movie name cannot be blank")
    private String title;

    private Integer duration;

    private String language;

    private String genre;

    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Show> movieShows = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, Integer duration, String language, String genre, LocalDate releaseDate) {
        this.title = title;
        this.duration = duration;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public void addMovieShow(Show show) {
        this.movieShows.add(show);
        show.setMovie(this);
    }
}
