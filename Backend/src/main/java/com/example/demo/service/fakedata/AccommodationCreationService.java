package com.example.demo.service.fakedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Accommodation;
import com.example.demo.repository.AccommodationRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AccommodationCreationService {
    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationCreationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void loadJsonData() {
        for (int j = 0; j < 4; j++) {
            int baseHouseNumber = (1 + j)*100;
            for (int i = 0; i < 4; i++) {
                accommodationRepository.save(new Accommodation(baseHouseNumber+i, j+1));
            }
        }
    }
}
