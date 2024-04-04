package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String guestName;
    private String guestEmail;
    private int numberOfAdulst;
    private int numberOfChildren;
    private int numberOfPets;
    private String bookingConfirmationcode;
    private String accommodation;
}
