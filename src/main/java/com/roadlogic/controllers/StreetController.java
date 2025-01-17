package com.roadlogic.controllers;

import com.roadlogic.models.Street;
import com.roadlogic.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
