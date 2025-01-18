package com.roadlogic.controllers;

import com.roadlogic.models.Street;
import com.roadlogic.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @PostMapping
    public Street addStreet(@RequestBody Street street) {
        return streetService.saveStreet(street);
    }

    @GetMapping
    public List<Street> getAllStreets() {
        return streetService.getAllStreets();
    }

    @GetMapping("/{id}")
    public Street getStreetById(@PathVariable Long id) {
        return streetService.getStreetById(id)
                .orElseThrow(() -> new RuntimeException("Street not found with id " + id));
    }

    @PutMapping("/{id}")
    public Street updateStreet(@PathVariable Long id, @RequestBody Street street) {
        return streetService.updateStreet(id, street);
    }

    @DeleteMapping("/{id}")
    public void deleteStreet(@PathVariable Long id) {
        streetService.deleteStreet(id);
    }
}
