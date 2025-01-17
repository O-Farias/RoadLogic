package com.roadlogic.controllers;

import com.roadlogic.models.Street;
import com.roadlogic.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/streets")
public class StreetController {

    @Autowired
    private StreetRepository streetRepository;

    @PostMapping
    public Street addStreet(@RequestBody Street street) {
        return streetRepository.save(street);
    }

    @GetMapping
    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Street> updateStreet(@PathVariable Long id, @RequestBody Street updatedStreet) {
        Optional<Street> optionalStreet = streetRepository.findById(id);
        if (optionalStreet.isPresent()) {
            Street street = optionalStreet.get();
            street.setName(updatedStreet.getName());
            street.setLength(updatedStreet.getLength());
            streetRepository.save(street);
            return ResponseEntity.ok(street);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStreet(@PathVariable Long id) {
        if (streetRepository.existsById(id)) {
            streetRepository.deleteById(id);
            return ResponseEntity.ok("Street deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
