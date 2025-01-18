package com.roadlogic.controllers;

import com.roadlogic.models.Intersection;
import com.roadlogic.services.IntersectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/intersections")
public class IntersectionController {

    @Autowired
    private IntersectionService intersectionService;

    @PostMapping
    public Intersection addIntersection(@RequestBody Intersection intersection) {
        return intersectionService.saveIntersection(intersection);
    }

    @GetMapping
    public List<Intersection> getAllIntersections() {
        return intersectionService.getAllIntersections();
    }

    @GetMapping("/{id}")
    public Intersection getIntersectionById(@PathVariable Long id) {
        return intersectionService.getIntersectionById(id)
                .orElseThrow(() -> new RuntimeException("Intersection not found with id " + id));
    }

    @PutMapping("/{id}")
    public Intersection updateIntersection(@PathVariable Long id, @RequestBody Intersection intersection) {
        return intersectionService.updateIntersection(id, intersection);
    }

    @DeleteMapping("/{id}")
    public void deleteIntersection(@PathVariable Long id) {
        intersectionService.deleteIntersection(id);
    }
}
