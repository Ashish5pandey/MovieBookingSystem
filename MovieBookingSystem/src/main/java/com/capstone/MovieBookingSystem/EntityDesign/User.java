package com.capstone.MovieBookingSystem.EntityDesign;

import com.capstone.MovieBookingSystem.Integration.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    @Enumerated(EnumType.STRING)
    private Role role;
}
