package com.capstone.MovieBookingSystem.Repositories;

import com.capstone.MovieBookingSystem.EntityDesign.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieMovieId(Long movieId);
    List<Showtime> findByTheaterTheaterId(Long theaterId);
}
