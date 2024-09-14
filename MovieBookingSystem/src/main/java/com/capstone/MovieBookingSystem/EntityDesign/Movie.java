package com.capstone.MovieBookingSystem.EntityDesign;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;
    private String description;
    private String genre;
    private int duration; // Duration in minutes
    private double rating;

    @OneToMany(mappedBy = "movie")
    private List<Showtime> showtimes;
}
