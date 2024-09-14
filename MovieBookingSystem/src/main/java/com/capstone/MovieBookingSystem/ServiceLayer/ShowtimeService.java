package com.capstone.MovieBookingSystem.ServiceLayer;

import com.capstone.MovieBookingSystem.EntityDesign.Movie;
import com.capstone.MovieBookingSystem.EntityDesign.Showtime;
import com.capstone.MovieBookingSystem.EntityDesign.Theater;
import com.capstone.MovieBookingSystem.Repositories.MovieRepository;
import com.capstone.MovieBookingSystem.Repositories.ShowtimeRepository;
import com.capstone.MovieBookingSystem.Repositories.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime addShowtime(Showtime showtime, Long movieId, Long theaterId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() -> new RuntimeException("Theater not found"));
        showtime.setMovie(movie);
        showtime.setTheater(theater);
        return showtimeRepository.save(showtime);
    }

    public Showtime updateShowtime(Long showtimeId, Showtime updatedShowtime) {
        updatedShowtime.setShowtimeId(showtimeId);
        return showtimeRepository.save(updatedShowtime);
    }

    public void deleteShowtime(Long showtimeId) {
        showtimeRepository.deleteById(showtimeId);
    }

    public Showtime getShowtime(Long showtimeId) {
        return showtimeRepository.findById(showtimeId).orElseThrow(() -> new RuntimeException("Showtime not found"));
    }

    public List<Showtime> getShowtimesForMovie(Long movieId) {
        return showtimeRepository.findByMovieMovieId(movieId);
    }

    public List<Showtime> getShowtimesForTheater(Long theaterId) {
        return showtimeRepository.findByTheaterTheaterId(theaterId);
    }
}
