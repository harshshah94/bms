package com.intuit.bms.repository;

import com.intuit.bms.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

//    List<Show> findByMovie_MovieId_AndStartTime(Long movieId, LocalDateTime startTime);
}
