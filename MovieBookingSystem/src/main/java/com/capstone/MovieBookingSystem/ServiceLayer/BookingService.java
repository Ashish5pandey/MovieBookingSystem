package com.capstone.MovieBookingSystem.ServiceLayer;

import com.capstone.MovieBookingSystem.EntityDesign.Booking;
import com.capstone.MovieBookingSystem.EntityDesign.Showtime;
import com.capstone.MovieBookingSystem.EntityDesign.User;
import com.capstone.MovieBookingSystem.Repositories.BookingRepository;
import com.capstone.MovieBookingSystem.Repositories.ShowtimeRepository;
import com.capstone.MovieBookingSystem.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowtimeRepository showtimeRepository;

    public Booking createBooking(Booking booking, Long userId, Long showtimeId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Showtime showtime = showtimeRepository.findById(showtimeId).orElseThrow(() -> new RuntimeException("Showtime not found"));
        booking.setUser(user);
        booking.setShowtime(showtime);
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        updatedBooking.setBookingId(bookingId);
        return bookingRepository.save(updatedBooking);
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<Booking> getAllBookingsForUser(Long userId) {
        return bookingRepository.findByUserUserId(userId);
    }
}
