package com.roadlogic.services;

import com.roadlogic.models.Street;
import com.roadlogic.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    public Street addStreet(Street street) {
        return streetRepository.save(street);
    }
}
