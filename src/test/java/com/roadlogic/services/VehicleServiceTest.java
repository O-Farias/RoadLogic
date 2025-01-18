package com.roadlogic.services;

import com.roadlogic.models.Vehicle;
import com.roadlogic.repositories.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVehicles() {
        List<Vehicle> mockVehicles = List.of(new Vehicle(1L, "Carro 1", "Car", 60, 100, false));
        when(vehicleRepository.findAll()).thenReturn(mockVehicles);

        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        assertNotNull(vehicles);
        assertEquals(1, vehicles.size());
        verify(vehicleRepository, times(1)).findAll();
    }

    @Test
    void testAddVehicle() {
        Vehicle newVehicle = new Vehicle(null, "Carro 2", "Truck", 40, 80, true);
        when(vehicleRepository.save(newVehicle)).thenReturn(new Vehicle(1L, "Carro 2", "Truck", 40, 80, true));

        Vehicle savedVehicle = vehicleService.saveVehicle(newVehicle);

        assertNotNull(savedVehicle);
        assertEquals("Carro 2", savedVehicle.getName());
        verify(vehicleRepository, times(1)).save(newVehicle);
    }

    @Test
    void testGetVehicleById() {
        Vehicle mockVehicle = new Vehicle(1L, "Carro 3", "Bike", 20, 50, false);
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(mockVehicle));

        Optional<Vehicle> vehicle = vehicleService.getVehicleById(1L);

        assertTrue(vehicle.isPresent());
        assertEquals("Carro 3", vehicle.get().getName());
        verify(vehicleRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateVehicle() {
        Vehicle existingVehicle = new Vehicle(1L, "Carro 4", "Bus", 30, 60, false);
        Vehicle updatedVehicleData = new Vehicle(null, "Carro Atualizado", "Bus", 50, 70, false);

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(existingVehicle));
        when(vehicleRepository.save(existingVehicle)).thenReturn(existingVehicle);

        Vehicle updatedVehicle = vehicleService.updateVehicle(1L, updatedVehicleData);

        assertNotNull(updatedVehicle);
        assertEquals("Carro Atualizado", updatedVehicle.getName());
        verify(vehicleRepository, times(1)).findById(1L);
        verify(vehicleRepository, times(1)).save(existingVehicle);
    }

    @Test
    void testDeleteVehicle() {
        doNothing().when(vehicleRepository).deleteById(1L);

        vehicleService.deleteVehicle(1L);

        verify(vehicleRepository, times(1)).deleteById(1L);
    }
}
