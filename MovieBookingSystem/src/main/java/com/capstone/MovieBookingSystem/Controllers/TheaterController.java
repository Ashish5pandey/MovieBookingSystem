package com.capstone.MovieBookingSystem.Controllers;

import com.capstone.MovieBookingSystem.EntityDesign.Theater;
import com.capstone.MovieBookingSystem.ServiceLayer.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @PostMapping
    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater) {
        return ResponseEntity.ok(theaterService.addTheater(theater));
    }

    @PutMapping("/{theaterId}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long theaterId, @RequestBody Theater updatedTheater) {
        return ResponseEntity.ok(theaterService.updateTheater(theaterId, updatedTheater));
    }

    @DeleteMapping("/{theaterId}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long theaterId) {
        theaterService.deleteTheater(theaterId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{theaterId}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long theaterId) {
        return ResponseEntity.ok(theaterService.getTheater(theaterId));
    }
}
