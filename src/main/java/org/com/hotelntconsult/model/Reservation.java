package org.com.hotelntconsult.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String contact;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int rooms;
    private int guests;
    private String status;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}