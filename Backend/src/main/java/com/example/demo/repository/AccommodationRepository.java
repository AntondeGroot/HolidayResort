package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{

}