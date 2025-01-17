package com.roadlogic.services;

import com.roadlogic.models.Intersection;
import com.roadlogic.repositories.IntersectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntersectionService {

    @Autowired
    private IntersectionRepository intersectionRepository;

    public List<Intersection> getAllIntersections() {
        return intersectionRepository.findAll();
    }

    public Intersection saveIntersection(Intersection intersection) { 
        return intersectionRepository.save(intersection);
    }

    public Optional<Intersection> getIntersectionById(Long id) {
        return intersectionRepository.findById(id);
    }

    public Intersection updateIntersection(Long id, Intersection intersection) {
        return intersectionRepository.findById(id)
                .map(existingIntersection -> {
                    existingIntersection.setType(intersection.getType());
                    existingIntersection.setTrafficLight(intersection.getTrafficLight());
                    existingIntersection.setCoordinatesX(intersection.getCoordinatesX());
                    existingIntersection.setCoordinatesY(intersection.getCoordinatesY());
                    existingIntersection.setMaxVehicles(intersection.getMaxVehicles());
                    return intersectionRepository.save(existingIntersection);
                })
                .orElseThrow(() -> new RuntimeException("Intersection not found with id " + id));
    }

    public void deleteIntersection(Long id) {
        intersectionRepository.deleteById(id);
    }
}
