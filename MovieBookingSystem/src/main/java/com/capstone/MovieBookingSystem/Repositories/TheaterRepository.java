package com.capstone.MovieBookingSystem.Repositories;

import com.capstone.MovieBookingSystem.EntityDesign.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
