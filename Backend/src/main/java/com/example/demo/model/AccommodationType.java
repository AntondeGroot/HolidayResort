package com.example.demo.model;

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
public class AccommodationType {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int price;
    private int maxGuests;
    
    @Override
    public String toString() {
        return "AccommodationType [id=" + id + ", name=" + name + ", price=" + price + ", maxNumberOfGuests="
                + maxGuests + "]";
    }

}
