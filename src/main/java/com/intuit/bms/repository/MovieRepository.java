package com.intuit.bms.repository;

import com.intuit.bms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Optional<Movie> findByTitle(String title);

//    @Query(value = "select * from Movie m join Show s where m.movie_id = s.movie_Id and s.start_time= :time", nativeQuery = true)
    public List<Movie> findByMovieShowsStartTime(LocalDateTime time);
}
