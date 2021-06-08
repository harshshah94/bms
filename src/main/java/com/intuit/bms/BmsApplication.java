package com.intuit.bms;

import com.intuit.bms.model.Address;
import com.intuit.bms.model.Cinema;
import com.intuit.bms.model.Movie;
import com.intuit.bms.model.Show;
import com.intuit.bms.repository.CinemaRepository;
import com.intuit.bms.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class, args);
    }


    @Bean
    public CommandLineRunner demoData(MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        return args -> {

            List<Show> movieShows = new ArrayList<>();
            Movie movie = new Movie("movie1", 150, "English", "Romcom", LocalDate.of(2019, 11, 15));

            Show movieShow = new Show(LocalDate.of(2021, 05, 23),
                    LocalDateTime.of(2021, 05, 23, 12, 00),
                    LocalDateTime.of(2021, 05, 23, 3, 00));

            movie.addMovieShow(movieShow);

            movieRepository.save(movie);


            Cinema cinema = Cinema.builder()
                    .cinemaName("AMC")
                    .address(Address.builder()
                            .streetAddress("123 Street")
                            .city("San Diego")
                            .zipCode("92129")
                            .country("USA")
                            .state("California")
                            .build())
                    .build();

            cinemaRepository.save(cinema);

        };
    }
}
