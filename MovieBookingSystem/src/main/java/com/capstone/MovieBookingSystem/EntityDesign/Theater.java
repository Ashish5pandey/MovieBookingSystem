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
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;
    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "theater")
    private List<Showtime> showtimes;
}
