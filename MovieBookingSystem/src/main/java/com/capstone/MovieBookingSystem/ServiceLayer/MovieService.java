package com.capstone.MovieBookingSystem.ServiceLayer;

import com.capstone.MovieBookingSystem.EntityDesign.Movie;
import com.capstone.MovieBookingSystem.Repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long movieId, Movie updatedMovie) {
        updatedMovie.setMovieId(movieId);
        return movieRepository.save(updatedMovie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}
