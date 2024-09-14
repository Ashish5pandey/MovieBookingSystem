package com.capstone.MovieBookingSystem.Repositories;

import com.capstone.MovieBookingSystem.EntityDesign.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserUserId(Long userId);
}
