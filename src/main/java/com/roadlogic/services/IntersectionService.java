package com.roadlogic.services;

import com.roadlogic.models.Intersection;
import com.roadlogic.repositories.IntersectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;


@Service
public class IntersectionService {

    @Autowired
    private IntersectionRepository intersectionRepository;

    public List<Intersection> getAllIntersections() {
        return intersectionRepository.findAll();
    }

    public Intersection addIntersection(Intersection intersection) { 
        return intersectionRepository.save(intersection);
    }

    public Intersection saveIntersection(Intersection intersection) {
        return intersectionRepository.save(intersection);
    }

    public Optional<Intersection> getIntersectionById(Long id) {
        return intersectionRepository.findById(id);
    }

    public Intersection updateIntersection(Long id, Intersection updatedIntersection) {
    Optional<Intersection> existingIntersectionOpt = intersectionRepository.findById(id);
    if (existingIntersectionOpt.isPresent()) {
        Intersection existingIntersection = existingIntersectionOpt.get();
        // Atualiza os campos
        existingIntersection.setName(updatedIntersection.getName());
        existingIntersection.setType(updatedIntersection.getType());
        existingIntersection.setLatitude(updatedIntersection.getLatitude());
        existingIntersection.setLongitude(updatedIntersection.getLongitude());
        existingIntersection.setTrafficFlow(updatedIntersection.getTrafficFlow());
        // Salva as mudanças
        return intersectionRepository.save(existingIntersection);
    } else {
        throw new EntityNotFoundException("Intersection not found");
    }
}


    public void deleteIntersection(Long id) {
        intersectionRepository.deleteById(id);
    }
}
