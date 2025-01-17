package com.roadlogic.repositories;

import com.roadlogic.models.Intersection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntersectionRepository extends JpaRepository<Intersection, Long> {
}
