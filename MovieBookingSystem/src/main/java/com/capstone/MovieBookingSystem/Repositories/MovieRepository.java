package com.capstone.MovieBookingSystem.Repositories;

import com.capstone.MovieBookingSystem.EntityDesign.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
