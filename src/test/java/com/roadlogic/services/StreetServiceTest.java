package com.roadlogic.services;

import com.roadlogic.models.Street;
import com.roadlogic.repositories.StreetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StreetServiceTest {

    @Mock
    private StreetRepository streetRepository;

    @InjectMocks
    private StreetService streetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStreets() {
        List<Street> mockStreets = List.of(new Street(1L, "Rua Principal", 500, "Asfalto", 60));
        when(streetRepository.findAll()).thenReturn(mockStreets);

        List<Street> streets = streetService.getAllStreets();

        assertNotNull(streets);
        assertEquals(1, streets.size());
        verify(streetRepository, times(1)).findAll();
    }

    @Test
    void testAddStreet() {
        Street newStreet = new Street(null, "Rua Secundária", 300, "Concreto", 50);
        when(streetRepository.save(newStreet)).thenReturn(new Street(1L, "Rua Secundária", 300, "Concreto", 50));

        Street savedStreet = streetService.saveStreet(newStreet);

        assertNotNull(savedStreet);
        assertEquals("Rua Secundária", savedStreet.getName());
        verify(streetRepository, times(1)).save(newStreet);
    }

    @Test
    void testGetStreetById() {
        Street mockStreet = new Street(1L, "Rua do Centro", 700, "Pedra", 40);
        when(streetRepository.findById(1L)).thenReturn(Optional.of(mockStreet));

        Optional<Street> street = streetService.getStreetById(1L);

        assertTrue(street.isPresent());
        assertEquals("Rua do Centro", street.get().getName());
        verify(streetRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateStreet() {
        Street existingStreet = new Street(1L, "Rua Antiga", 200, "Asfalto", 40);
        Street updatedStreetData = new Street(null, "Rua Atualizada", 400, "Concreto", 60);

        when(streetRepository.findById(1L)).thenReturn(Optional.of(existingStreet));
        when(streetRepository.save(existingStreet)).thenReturn(existingStreet);

        Street updatedStreet = streetService.updateStreet(1L, updatedStreetData);

        assertNotNull(updatedStreet);
        assertEquals("Rua Atualizada", updatedStreet.getName());
        verify(streetRepository, times(1)).findById(1L);
        verify(streetRepository, times(1)).save(existingStreet);
    }

    @Test
    void testDeleteStreet() {
        doNothing().when(streetRepository).deleteById(1L);

        streetService.deleteStreet(1L);

        verify(streetRepository, times(1)).deleteById(1L);
    }
}
