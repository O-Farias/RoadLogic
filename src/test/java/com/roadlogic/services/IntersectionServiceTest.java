package com.roadlogic.services;

import com.roadlogic.models.Intersection;
import com.roadlogic.models.Street;
import com.roadlogic.repositories.IntersectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IntersectionServiceTest {

    @Mock
    private IntersectionRepository intersectionRepository;

    @InjectMocks
    private IntersectionService intersectionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllIntersections() {
        List<Intersection> mockIntersections = new ArrayList<>();
        mockIntersections.add(new Intersection(1L, "Cruzamento", "Verde", 1.0, 1.0, 10, null, null));
        when(intersectionRepository.findAll()).thenReturn(mockIntersections);

        List<Intersection> intersections = intersectionService.getAllIntersections();

        assertNotNull(intersections);
        assertEquals(1, intersections.size());
        verify(intersectionRepository, times(1)).findAll();
    }

    @Test
    void testAddIntersection() {
        Intersection newIntersection = new Intersection(null, "Rotatória", "Amarelo", 2.0, 2.0, 5, null, null);
        when(intersectionRepository.save(newIntersection)).thenReturn(new Intersection(1L, "Rotatória", "Amarelo", 2.0, 2.0, 5, null, null));

        Intersection savedIntersection = intersectionService.addIntersection(newIntersection);

        assertNotNull(savedIntersection);
        assertEquals("Rotatória", savedIntersection.getType());
        assertEquals("Amarelo", savedIntersection.getTrafficLight());
        verify(intersectionRepository, times(1)).save(newIntersection);
    }

    @Test
    void testGetIntersectionById() {
        Intersection mockIntersection = new Intersection(1L, "Cruzamento", "Vermelho", 1.0, 1.0, 15, null, null);
        when(intersectionRepository.findById(1L)).thenReturn(Optional.of(mockIntersection));

        Optional<Intersection> intersection = intersectionService.getIntersectionById(1L);

        assertTrue(intersection.isPresent());
        assertEquals("Cruzamento", intersection.get().getType());
        verify(intersectionRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateIntersection() {
        Intersection existingIntersection = new Intersection(1L, "Antigo Cruzamento", "Vermelho", 1.0, 1.0, 10, null, null);
        Intersection updatedIntersectionData = new Intersection(null, "Novo Cruzamento", "Verde", 3.0, 3.0, 20, null, null);

        when(intersectionRepository.findById(1L)).thenReturn(Optional.of(existingIntersection));
        when(intersectionRepository.save(existingIntersection)).thenReturn(existingIntersection);

        Intersection updatedIntersection = intersectionService.updateIntersection(1L, updatedIntersectionData);

        assertNotNull(updatedIntersection);
        assertEquals("Novo Cruzamento", updatedIntersection.getType());
        assertEquals("Verde", updatedIntersection.getTrafficLight());
        assertEquals(20, updatedIntersection.getMaxVehicles());
        verify(intersectionRepository, times(1)).findById(1L);
        verify(intersectionRepository, times(1)).save(existingIntersection);
    }

    @Test
    void testDeleteIntersection() {
        Intersection mockIntersection = new Intersection(1L, "Cruzamento para Deletar", "Amarelo", 2.0, 2.0, 5, null, null);
        when(intersectionRepository.findById(1L)).thenReturn(Optional.of(mockIntersection));
        doNothing().when(intersectionRepository).deleteById(1L);

        intersectionService.deleteIntersection(1L);

        verify(intersectionRepository, times(1)).deleteById(1L);
    }
}
