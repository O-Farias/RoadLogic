package com.roadlogic.services;

import com.roadlogic.models.Intersection;
import com.roadlogic.repositories.IntersectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
