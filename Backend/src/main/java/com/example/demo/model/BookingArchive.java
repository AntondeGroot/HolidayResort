package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookingArchive{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookingId;
    private LocalDate archivedDate;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String guestName;
    private String guestEmail;
    private int numberOfAdulst;
    private int numberOfChildren;
    private int numberOfPets;
    private String bookingConfirmationcode;
    private String accommodation;
    

    public BookingArchive(Booking booking) {
        this.archivedDate = LocalDate.now(); 
        this.bookingId = booking.getBookingId();
        this.checkinDate = booking.getCheckinDate();
        this.checkoutDate = booking.getCheckoutDate();
        this.guestName = booking.getGuestName();
        this.guestEmail = booking.getGuestEmail();
        this.numberOfAdulst = booking.getNumberOfAdulst();
        this.numberOfChildren = booking.getNumberOfChildren();
        this.numberOfPets = booking.getNumberOfPets();
        this.bookingConfirmationcode = booking.getBookingConfirmationcode();
        this.accommodation = booking.getAccommodation();
    }
    
}
