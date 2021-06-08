package com.intuit.bms.service;

import com.intuit.bms.exception.MovieException;
import com.intuit.bms.model.Movie;
import com.intuit.bms.repository.MovieRepository;
import com.intuit.bms.repository.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;


    public Movie saveMovie(Movie movieReq) throws MovieException {

        Optional<Movie> movie = movieRepository.findByTitle(movieReq.getTitle());

        if (movie.isPresent()) {
            throw new MovieException(MovieException.TitleAlreadyExists());
        }
        Movie movieSaved = this.movieRepository.save(movieReq);
        return movieSaved;
    }

    public Movie findByTitle(String title) throws MovieException {

        if (title == null)
            throw new MovieException(MovieException.TitleEmptyException());
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new MovieException(MovieException.NotFoundException(title)));
        return movie;
    }

    public List<Movie> findMovieShowByTime(LocalDateTime time) throws MovieException {

        List<Movie> movieList = movieRepository.findByMovieShowsStartTime(time);

        return movieList;
    }

    /**
     * Update Movie duration
     * @param movieId
     * @param movie
     * @return Movie : returns updated movie object
     * @throws MovieException
     */
    public Movie updateMovieDuration(Long movieId, Movie movie) throws MovieException {
        Movie movieFound = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieException(MovieException.NotFoundException(String.valueOf(movieId))));

        movieFound.setDuration(movie.getDuration());

        return movieRepository.save(movieFound);
    }


    public void deleteMovieById(Long movieId) throws MovieException {

        Movie movieFound = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieException(MovieException.NotFoundException(String.valueOf(movieId))));

        movieRepository.delete(movieFound);
    }
}

