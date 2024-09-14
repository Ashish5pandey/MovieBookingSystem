package com.capstone.MovieBookingSystem.Controllers;

import com.capstone.MovieBookingSystem.EntityDesign.Showtime;
import com.capstone.MovieBookingSystem.ServiceLayer.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
@RequestMapping("/api/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {
    private final ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    @PostMapping
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime, @RequestParam Long movieId, @RequestParam Long theaterId) {
        return ResponseEntity.ok(showtimeService.addShowtime(showtime, movieId, theaterId));
    }

    @PutMapping("/{showtimeId}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Long showtimeId, @RequestBody Showtime updatedShowtime) {
        return ResponseEntity.ok(showtimeService.updateShowtime(showtimeId, updatedShowtime));
    }

    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long showtimeId) {
        showtimeService.deleteShowtime(showtimeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{showtimeId}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long showtimeId) {
        return ResponseEntity.ok(showtimeService.getShowtime(showtimeId));
    }

    @GetMapping("/movie/{movieId}")
    public List<Showtime> getShowtimesForMovie(@PathVariable Long movieId) {
        return showtimeService.getShowtimesForMovie(movieId);
    }

    @GetMapping("/theater/{theaterId}")
    public List<Showtime> getShowtimesForTheater(@PathVariable Long theaterId) { return showtimeService.getShowtimesForTheater(theaterId); } }