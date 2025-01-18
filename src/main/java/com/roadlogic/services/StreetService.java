package com.roadlogic.services;

import com.roadlogic.models.Street;
import com.roadlogic.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Street saveStreet(Street street) {
        return streetRepository.save(street);
    }

    public Optional<Street> getStreetById(Long id) {
        return streetRepository.findById(id);
    }

    public Street updateStreet(Long id, Street street) {
        return streetRepository.findById(id)
                .map(existingStreet -> {
                    existingStreet.setName(street.getName());
                    existingStreet.setLength(street.getLength());
                    return streetRepository.save(existingStreet);
                })
                .orElseThrow(() -> new RuntimeException("Street not found with id " + id));
    }

    public void deleteStreet(Long id) {
        streetRepository.deleteById(id);
    }
}
