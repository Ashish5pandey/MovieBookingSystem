package com.capstone.MovieBookingSystem.Controllers;

import com.capstone.MovieBookingSystem.EntityDesign.Booking;
import com.capstone.MovieBookingSystem.ServiceLayer.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking, @RequestParam Long userId, @RequestParam Long showtimeId) {
        return ResponseEntity.ok(bookingService.createBooking(booking, userId, showtimeId));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking updatedBooking) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, updatedBooking));
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getAllBookingsForUser(@PathVariable Long userId) {
        return bookingService.getAllBookingsForUser(userId);
    }
}
