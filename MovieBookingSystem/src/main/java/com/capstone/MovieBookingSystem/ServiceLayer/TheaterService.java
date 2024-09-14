package com.capstone.MovieBookingSystem.ServiceLayer;

import com.capstone.MovieBookingSystem.EntityDesign.Theater;
import com.capstone.MovieBookingSystem.Repositories.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long theaterId, Theater updatedTheater) {
        updatedTheater.setTheaterId(theaterId);
        return theaterRepository.save(updatedTheater);
    }

    public void deleteTheater(Long theaterId) {
        theaterRepository.deleteById(theaterId);
    }

    public Theater getTheater(Long theaterId) {
        return theaterRepository.findById(theaterId).orElseThrow(() -> new RuntimeException("Theater not found"));
    }
}
