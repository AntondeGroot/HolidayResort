package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Accommodation;
import com.example.demo.repository.AccommodationRepository;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    @Autowired
    private AccommodationRepository repository;

    @GetMapping()
    public List<Accommodation> retrieveAllAccommodations(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> retrieveAccommodationById(@PathVariable long id){
        return repository.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{id}")
    public List<Accommodation> retrieveAllAccommodationsByType(@PathVariable int id){
        return repository.findByTypeEquals(id);
    }
}
