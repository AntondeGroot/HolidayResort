package com.example.demo.service.fakedata;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationType;
import com.example.demo.repository.AccommodationTypeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class AccommodationTypeLoaderService {
    private final AccommodationTypeRepository accommodationTypeRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public AccommodationTypeLoaderService(AccommodationTypeRepository accommodationTypeRepository, ObjectMapper objectMapper) {
        this.accommodationTypeRepository = accommodationTypeRepository;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadJsonData() {
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/accommodationtypes.json");
            List<AccommodationType> accomodationtypes = objectMapper.readValue(inputStream, new TypeReference<List<AccommodationType>>() {});
            accommodationTypeRepository.saveAll(accomodationtypes);
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON data", e);
        }
    }
}
