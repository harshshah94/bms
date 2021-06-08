package com.intuit.bms.controller;

import com.intuit.bms.exception.MovieException;
import com.intuit.bms.mapper.MapStructMapper;
import com.intuit.bms.model.Movie;
import com.intuit.bms.model.Show;
import com.intuit.bms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bms/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MapStructMapper mapStructMapper;

    @GetMapping("/movie/{title}")
    public ResponseEntity getMovieByTitle(@PathVariable String title) {

        Movie movie = null;
        try {
            movie = movieService.findByTitle(title);
            return new ResponseEntity(mapStructMapper.movieToMovieDto(movie), HttpStatus.OK);
        } catch (MovieException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movie")
    public ResponseEntity getMovieShowByStartTime(@RequestParam Long movieId, @RequestParam String startTime) {

        List<Movie> movies = null;
        try {
            movies = movieService.findMovieShowByTime(LocalDateTime.parse(startTime));

            return new ResponseEntity(movies.stream().map(mapStructMapper::movieToMovieDto).collect(Collectors.toList()), HttpStatus.OK);
        } catch (MovieException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/movie")
    public ResponseEntity saveMovie(@RequestBody  Movie movieReq) {

        try {
           Movie movie = this.movieService.saveMovie(movieReq);
            return new ResponseEntity(movie, HttpStatus.OK);
        } catch(ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/movie/{movieId}")
    public ResponseEntity updateMovieDuration(@RequestBody Movie movieReq, @PathVariable Long movieId) {

        try {
            Movie movie = this.movieService.updateMovieDuration(movieId, movieReq);
            return new ResponseEntity(movie, HttpStatus.OK);
        } catch(ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity deleteMovie(@PathVariable Long movieId) {
        try {
            movieService.deleteMovieById(movieId);
            return new ResponseEntity("Movie deleted successfully", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
