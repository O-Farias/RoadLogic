package com.roadlogic.repositories;

import com.roadlogic.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
